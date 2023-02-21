package com.example.project.service;

import java.util.List;

import com.example.project.dto.CartDTO;

public interface CartService {
	public List<CartDTO> cartList(int userId) throws Exception;
	public int updateCart(int productId, int productCnt, int userId) throws Exception;
	public int deleteProductOfCart(int productId, int userId) throws Exception;
}
