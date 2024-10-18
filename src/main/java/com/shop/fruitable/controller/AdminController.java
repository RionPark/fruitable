package com.shop.fruitable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.fruitable.service.UserInfoService;
import com.shop.fruitable.vo.UserInfoVO;

@RestController
public class AdminController {

	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/admin/users")
	public List<UserInfoVO> getAllUsers(UserInfoVO user){
		return userInfoService.selectUsers(user);
	}
}
