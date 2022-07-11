package com.spring.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import com.spring.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" });
public class UserRestController {
	
	private final UserServiceImpl userService;
	
	@GetMapping(value = "/user/users")
	public PageResultDTO<UserDTO, User> getUsers(PageRequestDTO pageRequestDTO){
		PageResultDTO<UserDTO, User> pageResultDTO = userService.getList(pageRequestDTO);
		List<UserDTO> userList = new ArrayList<UserDTO>();
		pageResultDTO.getDtoList().forEach(UserDTO -> userList.add(UserDTO));
		
		return pageResultDTO;
	}
	
	@GetMapping(value = "/user/{userEmail}")
	public User getUserByUserEmail(@PathVariable String userEmail) {
		return userService.getUserByUserEmail(userEmail);
	}
	
	
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertUser(@RequestBody UserDTO userDTO) {
		userService.insertUser(userDTO);
	}
	
	@PutMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUserByUserEmail(@RequestBody UserDTO userDTO) {
		userService.updateUser(userDTO);
	}
	
	@DeleteMapping(value = "/user/{userEmail}")
	public void deleteUserByUserEmail(@PathVariable String userEmail) {
		User user = new User();
		user = getUserByUserEmail(userEmail);
		if (user == null) {
			System.out.println("입력하신 이메일이 존재하지 않습니다.");
		}else {
			userService.deleteUserByUserEmail(userEmail);
		}
	}
	
}
