package com.cms.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cms.example.model.User;

public class UserControllerTest {
	
	private MockMvc mockMvc;
	private static UserController mockedUserController;
	
	@Autowired
    private WebApplicationContext wac;

	
	private static User user1;
	private static User user2;
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void testgetAllUsers() throws Exception {
		
	    this.mockMvc.perform(post("/getAllUsers")).andExpect(status().isOk());
	}
	
	  }
