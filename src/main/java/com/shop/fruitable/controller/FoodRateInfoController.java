package com.shop.fruitable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.fruitable.service.FoodRateInfoService;
import com.shop.fruitable.vo.FoodRateInfoVO;

@RestController
public class FoodRateInfoController {

	@Autowired
	private FoodRateInfoService friService;
	
	@GetMapping("/food-rates")
	public List<FoodRateInfoVO> getFoodRates(FoodRateInfoVO foodRate){
		return friService.selectFoodRates(foodRate);
	}
	@GetMapping("/food-rates/{friNum}")
	public FoodRateInfoVO getFoodRate(@PathVariable int friNum) {
		return friService.selectFoodRate(friNum);
	}
	
	@PostMapping("/food-rates")
	public int insertFoodRate(@RequestBody FoodRateInfoVO foodRate) {
		return friService.insertFoodRate(foodRate);
	}
}
