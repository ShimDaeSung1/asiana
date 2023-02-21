package com.example.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.project.dto.ReviewDTO;

@Mapper
public interface ReviewMapper {
	public List<ReviewDTO> getReviewList(long productId) throws Exception;
	
}
