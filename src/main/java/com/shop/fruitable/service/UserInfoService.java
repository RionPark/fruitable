package com.shop.fruitable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.fruitable.mapper.UserInfoMapper;
import com.shop.fruitable.vo.UserInfoVO;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper usiMapper;
	public List<UserInfoVO> selectUsers(UserInfoVO user){
		return usiMapper.selectUsers(user);
	}
	public UserInfoVO selectUser(int usiNum){
		return usiMapper.selectUser(usiNum);
	}
	public UserInfoVO selectUserForLogin(UserInfoVO user){
		return usiMapper.selectUserForLogin(user);
	}
	public int insertUser(UserInfoVO user){
		return usiMapper.insertUser(user);
	}
	public int updateUser(UserInfoVO user){
		return usiMapper.updateUser(user);
	}
	public int deleteUser(int usiNum){
		return usiMapper.deleteUser(usiNum);
	}
}
