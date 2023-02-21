package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.dto.CartDTO;
import com.example.project.mapper.CartMapper;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartMapper mapper;

	@Override
	public List<CartDTO> cartList(int userId) throws Exception {
		return mapper.showCart(userId);
	}

	@Override
	public int updateCart(int productId, int productCnt, int userId) throws Exception {
		return mapper.updateCart(productId, productCnt, userId);
	}
	
	@Override
	public int deleteProductOfCart(int productId, int userId) throws Exception {
		return mapper.deleteProductOfCart(productId, userId);
	}

}
