package com.shop.fruitable.mapper;

import java.util.List;

import com.shop.fruitable.vo.FoodInfoVO;

public interface FoodInfoMapper {
	int selectFoodCount(FoodInfoVO food);
    List<FoodInfoVO> selectFoods(FoodInfoVO food);
    FoodInfoVO selectFood(int foiNum);
    int insertFood(FoodInfoVO foodInfo);
    int updateFood(FoodInfoVO foodInfo);
    int deleteFood(int foiNum);
}
