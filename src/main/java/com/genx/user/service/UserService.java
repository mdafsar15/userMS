package com.genx.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.genx.user.VO.Department;
import com.genx.user.VO.ResponseTemplateVO;
import com.genx.user.controller.UserController;
import com.genx.user.entity.User;
import com.genx.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public User findByUserId(Long userId) {
		log.info("inside findByUserId method of UserService");
		return userRepository.findByUserId(userId);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment method of UserService");

		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/deparments/"+ user.getDepartmentId(),Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
