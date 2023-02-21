package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.dto.order.OrderDTO;
import com.example.project.mapper.OrderMapper;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper mapper;

	@Override
	public int saveOrder(long userId, long productId) {
		OrderDTO dto = new OrderDTO();
		dto.setUserId(userId);
		dto.setProductId(productId);
		return mapper.saveOrder(dto);
	}

}
