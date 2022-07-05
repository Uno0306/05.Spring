package step06.entity;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
@ToString(exclude = {"order"})
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_id")
	private Long id;

	@Column(length = 20)
	private String name;

	private Integer age;

	@OneToMany(mappedBy = "member")	// -> null 주려면 위의 것 사용
//	@OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE})		// 참조하는 테이블 다 지우기
	private List<Order> order = new ArrayList<Order>();
	
}
