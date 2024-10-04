package com.shop.fruitable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shop.fruitable.service.FoodInfoService;
import com.shop.fruitable.vo.FoodInfoVO;
import com.shop.fruitable.vo.ResultList;

@RestController
public class FoodInfoController {
	
	@Autowired
	private FoodInfoService foiService;
	
	@GetMapping("/foods")
	public ResultList<FoodInfoVO> getFoods(FoodInfoVO food){
		return foiService.selectFoods(food);
	}
	
	@GetMapping("/foods/{foiNum}")
	public FoodInfoVO getFood(@PathVariable int foiNum) {
		return foiService.selectFood(foiNum);
	}
	
	@GetMapping("/test/{cnt}")
	public int test(@PathVariable int cnt) {
		try {
			Thread.sleep(cnt *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
