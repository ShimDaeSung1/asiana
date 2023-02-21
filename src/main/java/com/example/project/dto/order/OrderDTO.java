package com.example.project.dto.order;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("OrderDTO")
public class OrderDTO {
	Long id;
	OrderStatus orderStatus= OrderStatus.PROGRESS;
	Long userId;
	Long productId;
}
