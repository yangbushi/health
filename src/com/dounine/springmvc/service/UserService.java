package com.dounine.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dounine.springmvc.dao.UserMapper;
import com.dounine.springmvc.entity.User;

@Component
public class UserService {

	@Resource
	private UserMapper userMapper;
	
	public int add(User user){
		return userMapper.insert(user);
	}
	
	public boolean remove(Integer id){
		return userMapper.delete(id);
	}
	
	public User get(Integer id){
		return userMapper.get(id);
	}
	
	public User getFromNamePwd(User user){
		return userMapper.getFromNamePwd(user);
	}
}
