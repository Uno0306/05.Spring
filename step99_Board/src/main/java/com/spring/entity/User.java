package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@Getter
@AllArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class User implements Persistable<String>{

	@Id
	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_name", length = 255)
	private String userName;

	@Column(name = "user_password", length = 255)
	private String userPassword;

	@CreatedDate
	@Column(name="registered_date")
	private LocalDate registeredDate;

	@LastModifiedDate
	@Column(name="modified_date")
	private LocalDate modifiedDate;

	@Override
	public String getId() {
		return userEmail;
	}
	
	@Override	// 영속성이 있는지 판단하는 메소드
	public boolean isNew() {
		return registeredDate == null;
	}
	
	public UserDTO toDTO(User userEntity) {
		UserDTO userDTO = UserDTO.builder()
				.userEmail(userEntity.getUserEmail())
				.userName(userEntity.getUserName())
				.userPassword(userEntity.getUserPassword())
				.registeredDate(userEntity.getRegisteredDate())
				.modifiedDate(userEntity.getModifiedDate())
				.build();

		return userDTO;
	}

}
