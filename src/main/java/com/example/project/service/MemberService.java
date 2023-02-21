package com.example.project.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.project.dto.LoginDTO;
import com.example.project.dto.MemberDTO;
import com.example.project.oauth2.ProviderUser;

public interface MemberService {
	public int memberAdd(MemberDTO dto,PasswordEncoder passwordEncoder) throws Exception;
	public MemberDTO login(LoginDTO dto) throws Exception;
	public MemberDTO mypage(String userid)throws Exception;
	public int memberUpdate(MemberDTO dto) throws Exception;
	public int memberDelete(MemberDTO dto) throws Exception;
	public MemberDTO findByEmail(String email);
	public int saveSocialUser(String registrationId, ProviderUser providerUser);
}
