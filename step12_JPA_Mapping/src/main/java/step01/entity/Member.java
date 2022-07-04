package step01.entity;

import lombok.Data;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
//@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="member_name", length = 20)
	private String name;
	
	private Integer age;

	@Column(name="team_id")
	private Long teamId;
	
}
