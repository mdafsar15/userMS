package com.genx.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genx.user.VO.ResponseTemplateVO;
import com.genx.user.entity.User;
import com.genx.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("inside saveUser method of UserController");
		return userService.saveUser(user);
	}
	
//	@GetMapping("/{id}")
//	public User findByUserId(@PathVariable("id") Long userId) {
//		log.info("inside getUser method of UserController");
//		return userService.findByUserId(userId);
//	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("inside getUserWithDepartment method of UserController");
		return userService.getUserWithDepartment(userId);
	}
	

}
