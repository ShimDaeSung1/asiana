package com.example.project.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("MemberDTO")
public class MemberDTO{
	Long id;
	String passwd;
	String email;
	String post;
	String addr1;
	String addr2;
	String registrationId;
	Role roles;
}