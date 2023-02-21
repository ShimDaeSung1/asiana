package com.example.project.controller;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.dto.MemberDTO;
import com.example.project.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/signUp")
	public String signUpForm() {
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(MemberDTO dto, Model m){
		int n = 0;
		try {
			n = service.memberAdd(dto,passwordEncoder);
		} catch (Exception e) {
		}
		m.addAttribute("action", "회원관리");
		if(n==1) {
			System.out.println("성공");
			//성공
			m.addAttribute("message", "회원 등록 성공");
			m.addAttribute("status","1");
		}
		else {
			//실패
			System.out.println("실패");
			m.addAttribute("message", "회원 등록 실패");
			m.addAttribute("status","2");
		}
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/login/error") // 에러 발생 시 에러메시지 전달
    public String loginError(Model model) { 
        model.addAttribute("errorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "loginForm";
    }
	
	@GetMapping("/api/user") // TEST
	@ResponseBody
    public ResponseEntity<?> user(@AuthenticationPrincipal OAuth2User oAuth2user,Authentication authentication) {
		if(oAuth2user == null) {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return ResponseEntity.status(HttpStatus.OK).body(user.getUsername());
		}

        return ResponseEntity.status(HttpStatus.OK).body(oAuth2user);
    }
	
	@PutMapping("/member")
	public String memberUpdate(MemberDTO dto, Model model)throws Exception {
		System.out.println("memberUpdate "+ dto);
		
		int n = 0;
		try {
			n = service.memberUpdate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("action", "회원정보수정");
		if (n == 1) {
			model.addAttribute("message", "회원정보수정 성공");
		} else {
			model.addAttribute("message", "회원정보수정 실패");//컬럼 값이 너무 크거나 하는 경우 오류발생 처리
		}		
		return "memberResult";
	}
	
	@GetMapping("/updateForm")
	public String updateForm() {
		return "updateForm";
	}
	
	@GetMapping("/delete")
	public String memberDelete(HttpSession session) throws Exception{
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		int n = service.memberDelete(dto);
		session.invalidate();
		return "redirect:/";
	}
	
	@ExceptionHandler({Exception.class})
	public String error() {
		return "";	//error.html에서 예외메시지 출력
	}
}