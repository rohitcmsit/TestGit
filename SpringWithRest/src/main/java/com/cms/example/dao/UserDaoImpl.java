package com.cms.example.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.example.controller.UserController;
import com.cms.example.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	static Logger log = Logger.getLogger(UserDaoImpl.class);
    static String query = "SELECT * FROM USERS";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAllUsers() {
		log.info("findAllUsers() was called from controller ");
		List<User> userList = new ArrayList<User>();
		List list = jdbcTemplate.queryForList(query);
		
		log.info("got the List of Users from database ");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Map map = (Map)it.next();
			User u = new User();
			Integer bd = (Integer)map.get("id");
			int i = bd.intValue();
			u.setId(i);
			u.setName((String)map.get("name"));
			userList.add(u);
		}
		log.info("list obj is returned to controller");
		return userList;
	}
	public User findUserById(int id) {
		log.info("findUserById() was called from controller ");
		Map map = jdbcTemplate.queryForMap("SELECT * FROM USERS WHERE ID= ?",id);
		log.info("got the user obj from database ");
		User u;
		if(map != null) {
			u = new User();
			Integer bd = (Integer)map.get("id");
			int i = bd.intValue();
			u.setId(i);
			u.setName((String)map.get("name"));
		}
		else {
			u = null;
		}
		log.info("user obj sent to the client ");
			return u;
	}

	public String addUser(User obj) {
		log.info("add User() was called from controller ");
		String str=null;
		int id = obj.getId();
		String name = obj.getName();
		

		int i = jdbcTemplate.update("INSERT INTO USERS VALUES(?,?)",id, name);
		log.info("User obj added succefully into database");
		if(i == 1) {
			str = "user inserted";
		}
		
		return str;
	}
}