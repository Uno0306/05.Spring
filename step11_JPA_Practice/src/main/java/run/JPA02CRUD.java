package run;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entity.User;

public class JPA02CRUD {
	
	public static void insert(EntityManager em, int age, String name) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		System.out.println(user);
		em.persist(user);
	}
	public static void selectById(EntityManager em, Long id) {
		User user = em.find(User.class, id);
		System.out.println(user);
	}

	public static void updateAge(EntityManager em, Long id, int age) {
		User user = em.find(User.class, id);
		user.setAge(age);
		System.out.println(id+"님의 나이가 수정되었습니다.");
	}
	public static void updateName(EntityManager em, Long id, String name) {
		User user = em.find(User.class, id);
		user.setName(name);
		System.out.println(id+"님의 이름이 수정되었습니다.");
	}
	
	public static void delete(EntityManager em, Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}
	
	public static void selectAll(EntityManager em) {
		TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM user u", User.class);
		List<User> allMembers = typedQuery.getResultList();
		
		/* 1. List로 출력 */
//		System.out.println(allMembers);

		/* 2. 하나씩 출력 */
		for (User user : allMembers) {
			System.out.println(user);
		}

	}
	
	public static void selectAllName(EntityManager em) {
		List<String> allNames = em.createQuery("SELECT u.name FROM user u", String.class).getResultList();
		for (String name: allNames) {
			System.out.println(name);
		}
	}
	
}
