package com.cs.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.ssm.entity.User;
import com.cs.ssm.mapper.UserMapper;
import com.cs.ssm.service.UserService;
import com.cs.ssm.utils.BaseException;
import com.cs.ssm.utils.MD5Utils;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public User userLogin(String name, String pwd) {

		User user = userMapper.getUserByName(name);
		user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
		//判断用户名
		if(user == null) {
			throw new BaseException("用户名不存在");
		}
		//判断密码
		if(!user.getPassword().equals(MD5Utils.getMD5Str(pwd))) {
			throw new BaseException("密码不正确");
		}
		return user;
	}

	@Override
	public void registerUser(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setAccount(new BigDecimal(0));
		user.setCreateTime(new Date());
		userMapper.addUser(user);
	}
	@Override
	public boolean isExistUserName(String name) {
		User user = userMapper.getUserByName(name);
		//判断
		if(user == null) {
			return true;
		}else{
			return false;
		}
	}

}