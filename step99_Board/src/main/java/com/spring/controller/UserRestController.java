package com.spring.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertUser(@RequestBody UserDTO userDTO) {
		userService.insertUser(userDTO);
	}
	
}
