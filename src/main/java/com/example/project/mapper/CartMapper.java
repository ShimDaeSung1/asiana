package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.dto.CartDTO;

@Mapper
public interface CartMapper {
	// 회원의 전체 장바구니 목록 조회
	public List<CartDTO> showCart(int userId) throws Exception;
	
	// 장바구니 상품 목록의 개수 변경
	public int updateCart(int productId, int productCnt, int userId) throws Exception;
	public int deleteProductOfCart(int productId, int userId) throws Exception;
	// 장바구니의 상품 목록 제거
	
	
	
}