package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.dto.ReviewDTO;
import com.example.project.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	ReviewMapper mapper;
	
	@Transactional
	@Override
	public List<ReviewDTO> getReviewList(long productId) throws Exception {
		// TODO Auto-generated method stub
		List<ReviewDTO> dto = mapper.getReviewList(productId);
		return dto;
	}
	
}
