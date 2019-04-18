
package com.enjoy02.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoy02.dao.UserDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//默认注入容器 id userService
@Service
public class UserService {

	// @Autowired与Resource区别是什么？
	// Autowired 默认是以类型进行查找 Resource默认是名称进行查找

	@Resource(name = "userDao02")
	private UserDao userDao;

	@Autowired
	private LogService logService;



	@Transactional(propagation= Propagation.REQUIRED)
	public void add03() {
		logService.addLog();
		System.out.println(" userService02 add003...");
		userDao.add("enjoy", 20);
		int i = 1 / 0;

	}

	public UserDao getUserDao() {

		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		System.out.println("setUseDao");
		this.userDao = userDao;
	}

}
