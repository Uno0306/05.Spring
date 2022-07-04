package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "user")
public class User {
	
	// id
	@Id
	private Long id;
	
	// length = 20
	@Column(length = 20)
	private String name;
	
	// length = 3
	@Column(length = 3)
	private Integer age;
}
