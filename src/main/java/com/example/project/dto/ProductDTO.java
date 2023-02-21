package com.example.project.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ProductDTO")
@Component
public class ProductDTO {
	
	int id;
	int price;
	int stock;
	String name;
	int categoryId;
}
