package com.example.project.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ImageDTO")
@Component
public class ImageDTO {
	
	int id;
	String imgName;
	String imgUrl;
	String originName;
	int productId;

}
