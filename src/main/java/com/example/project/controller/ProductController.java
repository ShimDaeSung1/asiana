package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.dto.ImageDTO;
import com.example.project.dto.ProductDTO;
import com.example.project.dto.ProductDetailDTO;
import com.example.project.dto.ProductListDTO;
import com.example.project.dto.ProductPageRequestDTO;
import com.example.project.dto.ProductPageResultDTO;
import com.example.project.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/a")
	public String a() {
		log.info("a start");
		return "aaaaa";
	}
	
	@GetMapping("/product")
	// @ResponseBody ==> 리턴하는 DTO를 JSON 변경해서 바로 브라우저로 응답
	public String getOne(@RequestParam("id") int id, Model m) throws Exception {
		List<ProductDetailDTO> dto = service.getOne(id);
		System.out.println("sss");
		log.info("dto :: "+ dto);
		m.addAttribute("image", dto);
		return "products";
	}
	
	@PostMapping("/product")
	public String insertProduct(ProductDTO dto) throws Exception {
		log.info(dto);
		service.productInsert(dto);
		return "productList";
	}
	
	@PutMapping("/product")
	public String updateProduct(ProductDTO dto) throws Exception{
		service.productUpdate(dto);
		return "productList";
	}
	
//	@GetMapping("/product/list")
//	public String getProductList(Model m) throws Exception {
//		List<ProductListDTO> dto = service.getProductList();
//		m.addAttribute("list", dto);
//		log.info("dto :::"+dto);
//		return "productList";
//	}
	
	@GetMapping("/product/list")
	public String getList(ProductPageRequestDTO dto) throws Exception{
		log.info("get::"+dto);
		ProductPageResultDTO dto2 = service.getProductListWithPaging(dto);
		log.info("dto ::"+dto2);
		return "productList";
	}
	
	@DeleteMapping("/product")
	public String productDelete(int id) throws Exception{
		service.productDelete(id);
		return "productList";
	}

}
