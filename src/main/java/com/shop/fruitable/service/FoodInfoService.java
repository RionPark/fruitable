package com.shop.fruitable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.fruitable.mapper.FoodInfoMapper;
import com.shop.fruitable.vo.FoodInfoVO;
@Service
public class FoodInfoService {
	@Autowired
	private FoodInfoMapper foiMapper;
	
	public List<FoodInfoVO> selectFoods(FoodInfoVO food){
		if("1".equals(food.getOrderType())) {
			food.setOrderType(" FRI_RATE DESC");
		}
		return foiMapper.selectFoods(food);
	}
	public FoodInfoVO selectFood(int foiNum) {
		return foiMapper.selectFood(foiNum);
	}
	public int insertFood(FoodInfoVO foodInfo) {
		return foiMapper.insertFood(foodInfo);
	}
	public int updateFood(FoodInfoVO foodInfo) {
		return foiMapper.updateFood(foodInfo);
	}
	public int deleteFood(int foiNum) {
		return foiMapper.deleteFood(foiNum);
	}
}
