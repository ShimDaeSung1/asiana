package com.example.project.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.dto.CartDTO;
import com.example.project.service.CartService;


@Controller
public class CartController {
	
	@Autowired
	CartService service;
	
	@GetMapping("/cart")
	public List<CartDTO> cartList(@RequestParam int userId) throws Exception{
		List<CartDTO> cartList = service.cartList(userId);
		return cartList;
	}
	
	@PutMapping("/cart")
	public String updateCart(@RequestParam int productId, @RequestParam int productCnt, @RequestParam int userId) throws Exception {
		int n = service.updateCart(productId, productCnt, userId);
		return "cartList";
	}
	
	@DeleteMapping("/cart")
	public String deleteProduct(@RequestParam int productId, @RequestParam int userId) throws Exception {
		int n = service.deleteProductOfCart(productId, userId);
		return "forward:cartList";
	}
	
	
	@DeleteMapping("/multiDeleteInCart")
	public String multiDeleteInCart(HttpServletRequest request) {
		
		try {
			String [] checks = request.getParameterValues("check");
			Integer[] checkInt = Stream.of(checks).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
			List<Integer> list = Arrays.asList(checkInt);
			

//			int n = service.boardMultiDelete(list);

			//int n = service.boardMultiDelete(list);

	//		List<String> list = Arrays.asList(checks);
	//		int n = service.boardMultiDelete(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return "forward:list";
}	
	
	
	@ExceptionHandler({Exception.class})
	public String error() {
		return "";	//error.html에서 예외메시지 출력
	}
}