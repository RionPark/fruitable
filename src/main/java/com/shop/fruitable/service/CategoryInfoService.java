package com.shop.fruitable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.fruitable.mapper.CategoryInfoMapper;
import com.shop.fruitable.vo.CategoryInfoVO;

@Service
public class CategoryInfoService {
	@Autowired
	private CategoryInfoMapper caiMapper;
	
	public List<CategoryInfoVO> selectCategories(CategoryInfoVO category){
		List<CategoryInfoVO> categories = caiMapper.selectCategories(category);
		return categories;
	}
	public CategoryInfoVO selectCategory(Integer caiNum) {
		CategoryInfoVO category = caiMapper.selectCategory(caiNum);
		return category;
	}
}
