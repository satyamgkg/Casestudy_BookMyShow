package com.cg.service;

import java.util.List;

import com.cg.model.Users;

public interface UserService {

	public List<Users> getAllUser();
	public Users addUser(Users ad);
}
