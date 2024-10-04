package com.shop.fruitable.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.fruitable.service.UserInfoService;
import com.shop.fruitable.vo.UserInfoVO;

@RestController
public class UserInfoController {

	@Autowired
	private UserInfoService usiService;
	
	@GetMapping("/users")
	public List<UserInfoVO> getUsers(UserInfoVO user){
		return usiService.selectUsers(user);
	}
	@GetMapping("/users/{usiNum}")
	public UserInfoVO getUser(@PathVariable int usiNum){
		return usiService.selectUser(usiNum);
	}
	@PostMapping("/login")
	public UserInfoVO login(@RequestBody UserInfoVO user, HttpSession session) {
		UserInfoVO loginUser = usiService.selectUserForLogin(user);
		if(loginUser!=null) {
			session.setAttribute("user", loginUser);
		}
		return loginUser;
	}
	
	@PutMapping("/users")
	public int updateUser(UserInfoVO user, HttpSession session) {
		return usiService.updateUser(session, user);
	}
}
