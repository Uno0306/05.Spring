package step02.entity;

import lombok.Data;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
//@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="member_name", length = 20)
	private String name;
	
	private Integer age;

	@OneToOne // Team -> member
	@JoinColumn(name="team_id")
	private Team team;
	
}
