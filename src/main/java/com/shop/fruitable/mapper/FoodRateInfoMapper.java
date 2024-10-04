package com.shop.fruitable.mapper;

import java.util.List;

import com.shop.fruitable.vo.FoodRateInfoVO;

public interface FoodRateInfoMapper {
	List<FoodRateInfoVO> selectFoodRates(FoodRateInfoVO foodRate);
	FoodRateInfoVO selectFoodRate(int friNum);
	int insertFoodRate(FoodRateInfoVO foodRate);
}
