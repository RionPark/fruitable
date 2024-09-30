package com.shop.fruitable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.fruitable.service.CategoryInfoService;
import com.shop.fruitable.vo.CategoryInfoVO;

@RestController
public class CategoryInfoController {

	@Autowired
	private CategoryInfoService caiService;
	
	@GetMapping("/categories")
	public List<CategoryInfoVO> getCategories(CategoryInfoVO category){
		List<CategoryInfoVO> categories = caiService.selectCategories(category);
		return categories;
	}
}
