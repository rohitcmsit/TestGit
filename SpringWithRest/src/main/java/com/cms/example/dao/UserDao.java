package com.cms.example.dao;

import java.util.List;

import com.cms.example.model.User;

public interface UserDao {
	List<User> findAllUsers();
	User findUserById(int id);
	String addUser(User obj);
}