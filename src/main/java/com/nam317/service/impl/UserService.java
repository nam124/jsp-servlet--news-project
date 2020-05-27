package com.nam317.service.impl;

import javax.inject.Inject;

import com.nam317.dao.IUserDAO;
import com.nam317.model.UserModel;
import com.nam317.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
	return 	userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
