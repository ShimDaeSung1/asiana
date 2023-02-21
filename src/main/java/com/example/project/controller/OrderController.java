package com.example.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project.dto.MemberDTO;
import com.example.project.dto.ProductDTO;
import com.example.project.service.MemberServiceImpl;
import com.example.project.service.OrderServiceImpl;
import com.example.project.service.ProductServiceImpl;
import com.example.project.service.oauth2.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	
	private final MemberServiceImpl memberService;
	private final ProductServiceImpl productService;
	private final OrderServiceImpl orderService;
	
	@GetMapping("/order")
	public String testOrderForm(Model model) {
		model.addAttribute("product",new ProductDTO());
		return "test";
	}
	
	
	@GetMapping("/order/{product_id}")
	public String order(Principal principal,@PathVariable("product_id") Long productId) {
		MemberDTO memberDto = memberService.findByEmail(principal.getName());
		
		orderService.saveOrder(memberDto.getId(), productId);
		
		return "redirect:/";
	}

}
