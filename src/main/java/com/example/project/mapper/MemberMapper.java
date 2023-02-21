package com.example.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.dto.LoginDTO;
import com.example.project.dto.MemberDTO;
import com.example.project.oauth2.ProviderUser;

@Mapper
public interface MemberMapper {
	public int memberAdd(MemberDTO dto);
	public MemberDTO login(LoginDTO dto) throws Exception;
	public MemberDTO mypage(String userid)throws Exception;
	public int memberUpdate(MemberDTO dto) throws Exception;
	public int memberDelete(MemberDTO dto) throws Exception;
	public MemberDTO findByEmail(String email);
}