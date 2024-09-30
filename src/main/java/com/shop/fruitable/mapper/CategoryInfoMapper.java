package com.shop.fruitable.mapper;

import java.util.List;

import com.shop.fruitable.vo.CategoryInfoVO;

public interface CategoryInfoMapper {

	public List<CategoryInfoVO> selectCategories(CategoryInfoVO category);
	public CategoryInfoVO selectCategory(Integer caiNum);
	public int insertCategory(CategoryInfoVO category);
	public int updateCategory(CategoryInfoVO category);
	public int deleteCategory(Integer caiNum);
}
