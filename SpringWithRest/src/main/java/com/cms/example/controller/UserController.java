package com.cms.example.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.example.dao.UserDao;
import com.cms.example.model.User;

@RestController
public class UserController {
	static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/getUsers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
	List<User> userList=userDao.findAllUsers();
	log.info("findAllUser() called and List obj sent to client");
	return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	@RequestMapping(value="/getUserById/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id")int id){
		User u = userDao.findUserById(id);
		log.info("findUserByid() called and user obj sent to client");
		return new ResponseEntity<User>(u, HttpStatus.OK);		
	}
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String createNewUser(@RequestBody User user) {
		String str = userDao.addUser(user);
		log.info("AddUser() called and  obj ");
		return str;
	}
}
