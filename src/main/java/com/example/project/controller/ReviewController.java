package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.project.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ReviewController {
	@Autowired
	ReviewService service;
	
	@GetMapping("/review/{productId}")
	public String a(@PathVariable("productId") long productId) throws Exception {
		service.getReviewList(productId);
		return "reviewtest";
	}
	
}
