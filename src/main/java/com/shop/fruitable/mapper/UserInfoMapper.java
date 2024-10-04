package com.shop.fruitable.mapper;

import java.util.List;

import com.shop.fruitable.vo.UserInfoVO;

public interface UserInfoMapper {

	List<UserInfoVO> selectUsers(UserInfoVO user);
	UserInfoVO selectUser(int usiNum);
	UserInfoVO selectUserForLogin(UserInfoVO user);
	int insertUser(UserInfoVO user);
	int updateUser(UserInfoVO user);
	int deleteUser(int usiNum);
}
