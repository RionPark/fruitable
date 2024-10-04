package com.shop.fruitable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.fruitable.mapper.FoodInfoMapper;
import com.shop.fruitable.vo.FoodInfoVO;
import com.shop.fruitable.vo.ResultList;
@Service
public class FoodInfoService {
	@Autowired
	private FoodInfoMapper foiMapper;
	
	public ResultList<FoodInfoVO> selectFoods(FoodInfoVO food){
		if(food.getCount()==0) {
			food.setCount(9);
		}
		if("1".equals(food.getOrderType())) {
			food.setOrderType(" FRI_RATE DESC");
		}else if("2".equals(food.getOrderType())) {
			food.setOrderType(" FOI_PRICE DESC");
		}else if("3".equals(food.getOrderType())) {
			food.setOrderType(" FOI_PRICE ASC");
		}
		ResultList<FoodInfoVO> list = new ResultList<>();
		list.setList(foiMapper.selectFoods(food));
		list.setCount(foiMapper.selectFoodCount(food));
		return list;
	}
	

	public PageInfo<FoodInfoVO> selectFoods2(FoodInfoVO food){
		if(food.getCount()==0) {
			food.setCount(9);
		}
		PageHelper.startPage(food.getStart(), food.getCount());
		if("1".equals(food.getOrderType())) {
			food.setOrderType(" FRI_RATE DESC");
		}else if("2".equals(food.getOrderType())) {
			food.setOrderType(" FOI_PRICE DESC");
		}else if("3".equals(food.getOrderType())) {
			food.setOrderType(" FOI_PRICE ASC");
		}
		List<FoodInfoVO> list = foiMapper.selectFoods(food);
		return new PageInfo<>(list);
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
