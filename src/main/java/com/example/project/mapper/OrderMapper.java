package com.example.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.dto.order.OrderDTO;

@Mapper
public interface OrderMapper {
	public int saveOrder(OrderDTO orderDTO);
}
