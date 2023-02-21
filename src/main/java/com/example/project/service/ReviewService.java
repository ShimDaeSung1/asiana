package com.example.project.service;

import java.util.List;

import com.example.project.dto.ReviewDTO;

public interface ReviewService {
	public List<ReviewDTO> getReviewList(long productId) throws Exception;
	
}
