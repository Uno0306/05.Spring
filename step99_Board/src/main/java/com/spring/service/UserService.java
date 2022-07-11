package com.spring.service;

import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;

public interface UserService {

	public PageResultDTO<UserDTO, User> getList(PageRequestDTO pageRequestDTO);

	public User getUserByUserEmail(String userEmail);
	
	public void insertUser(UserDTO userDTO);
	
	public void updateUser(UserDTO userDTO);
	
	public void deleteUserByUserEmail(String userEmail);
}
