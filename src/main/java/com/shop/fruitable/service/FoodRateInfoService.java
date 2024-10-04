package com.shop.fruitable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.fruitable.mapper.FoodRateInfoMapper;
import com.shop.fruitable.vo.FoodRateInfoVO;

@Service
public class FoodRateInfoService {

	@Autowired
	private FoodRateInfoMapper friMapper;
	
	public List<FoodRateInfoVO> selectFoodRates(FoodRateInfoVO foodRate){
		return friMapper.selectFoodRates(foodRate);
	}
	public FoodRateInfoVO selectFoodRate(int friNum) {
		return friMapper.selectFoodRate(friNum);
	}
	public int insertFoodRate(FoodRateInfoVO foodRate) {
		return friMapper.insertFoodRate(foodRate);
	}
}
