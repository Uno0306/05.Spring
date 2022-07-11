package com.spring.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;

import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

	@Id
	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_name", length = 255)
	private String userName;

	@Column(name = "user_password", length = 255)
	private String userPassword;

	@Column(name="registered_date")
	private LocalDate registeredDate;

	@Column(name="modified_date")
	private LocalDate modifiedDate;


	public User toEntity(UserDTO userDTO) {
		User userEntity = User.builder()
				.userEmail(userDTO.getUserEmail())
				.userName(userDTO.getUserName())
				.userPassword(userDTO.getUserPassword())
				.build();

		return userEntity;
	}

}
