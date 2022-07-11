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
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("user_email").descending());
		Page<User> result = userRepo.findAll(pageable);
		Function<User, UserDTO> function = (userEntity -> userEntity.toDTO(userEntity));

		return new PageResultDTO<UserDTO, User>(result, function);
	};
	
	@Transactional
	@Override
	public void insertUser(UserDTO userDTO) {
		User userEntity = userDTO.toEntity(userDTO);
		
		userRepo.save(userEntity);
	}
	
}
