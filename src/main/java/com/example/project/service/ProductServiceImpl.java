package com.example.project.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.dto.ImageDTO;
import com.example.project.dto.ProductDTO;
import com.example.project.dto.ProductDetailDTO;
import com.example.project.dto.ProductListDTO;
import com.example.project.dto.ProductPageRequestDTO;
import com.example.project.dto.ProductPageResultDTO;
import com.example.project.exception.NoProductException;
import com.example.project.exception.NoProductStockException;
import com.example.project.exception.handler.ErrorCode;
import com.example.project.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductMapper mapper;
	
	@Transactional
	@Override
	public List<ProductListDTO> getProductList() throws Exception {
		List<ProductListDTO> dto = mapper.getProductList();
		return dto;
	}

	@Transactional
	@Override
	public List<ProductDetailDTO> getOne(int id) throws Exception {
		List<ProductDetailDTO> dto = mapper.getOne(id);
		if(dto.get(0).getProductDTO().getStock() == 0) {
			throw new NoProductStockException("이 상품은 재고가 없습니다.", ErrorCode.NOT_FOUND);
		}
		return dto;
	}
	
//	@Transactional
//	@Override
//	public List<ProductListDTO> getProductListWithPaging(ProductPageRequestDTO productPageRequestDTO) throws Exception {
//		
//		return mapper.getProductListWithPaging(productPageRequestDTO);
//	}

	@Transactional
	@Override
	public ProductPageResultDTO getProductListWithPaging(ProductPageRequestDTO requestDTO) throws Exception {
		ProductPageResultDTO pageDTO = new ProductPageResultDTO();
		//List<ProductListDTO>저장
		List<ProductListDTO> dtoList = mapper.getProductListWithPaging(requestDTO);
		//totalRecord저장
		int totalRecord = mapper.totalRecord(requestDTO);
		pageDTO.setDtoList(dtoList); // 1.dto List 저장
		pageDTO.makeTotalPages(totalRecord); // 2. 전체 개수 저장
		pageDTO.makePageList(requestDTO); // 3. 페이지 리스트 저장
		
	
		return pageDTO;
	}
	
	@Transactional
	@Override
	public void productInsert(ProductDTO productDTO) throws Exception {
		mapper.productInsert(productDTO);
		
	}
	@Transactional
	@Override
	public void productUpdate(ProductDTO productDTO) throws Exception {
		int n = mapper.productUpdate(productDTO);
		if(n==0) {
			throw new NoProductException("존재하지 않는 상품입니다.", ErrorCode.NOT_FOUND);
		}
	}

	@Override
	public void productDelete(int id) throws Exception {
		int n = mapper.productDelete(id);
	}
}
