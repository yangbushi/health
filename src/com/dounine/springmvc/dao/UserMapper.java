package com.dounine.springmvc.dao;

import com.dounine.springmvc.entity.User;

public interface UserMapper {

	public int insert(User user);
	
	public boolean delete(Integer id);
	
	public User get(Integer id);
	
	public User getFromNamePwd(User user);
	
	public User getRole(User user);
}
