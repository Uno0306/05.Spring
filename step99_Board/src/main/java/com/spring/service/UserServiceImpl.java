package com.spring.service;

import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import com.spring.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepo;
	
	@Transactional
	@Override
	public PageResultDTO<UserDTO, User> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("userEmail").descending());
		Page<User> result = userRepo.findAll(pageable);
		Function<User, UserDTO> function = (userEntity -> userEntity.toDTO(userEntity));

		return new PageResultDTO<UserDTO, User>(result, function);
	};
	
	@Transactional
	@Override
	public User getUserByUserEmail(String userEmail) {
		return userRepo.findUserByUserEmail(userEmail);
	}
	
	@Transactional
	@Override
	public void insertUser(UserDTO userDTO) {
		User userEntity = userDTO.toEntity(userDTO);
		
		userRepo.save(userEntity);
	}
	
	@Transactional
	@Override
	public void updateUser(UserDTO userDTO) {
		User user = getUserByUserEmail(userDTO.getUserEmail());
		User userEntity = User.builder()
							.userEmail(userDTO.getUserEmail())
							.userName(userDTO.getUserName())
							.userPassword(userDTO.getUserPassword())
							.registeredDate(user.getRegisteredDate())
							.build();
		
		userRepo.save(userEntity);
	}
	
	@Transactional
	@Override
	public void deleteUserByUserEmail(String userEmail) {
		userRepo.deleteUserByUserEmail(userEmail);
	}
}
