package com.cs.ssm.service;

import com.cs.ssm.entity.User;

public interface UserService {

	public User userLogin(String name, String pwd);

	public void registerUser(String name,String password);

	public boolean isExistUserName(String name);
}
