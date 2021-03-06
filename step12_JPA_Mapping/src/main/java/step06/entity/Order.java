package step06.entity;

//import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity(name = "order_data")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="order_id")
	private Long id;
	
	@ManyToOne
//	@JoinColumn(name = "member_id")
	@JoinColumn(name = "member_id", foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (member_id) references member (member_id) ON DELETE SET NULL"))
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	// ex
//	private LocalDateTime orderdTime;
	
//	@JoinColumn(name="company_id")
//	private Company company;
	
}
