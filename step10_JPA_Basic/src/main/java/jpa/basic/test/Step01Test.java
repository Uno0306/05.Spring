package jpa.basic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;

public class Step01Test {

	public static void main(String[] args) {
		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("step01_JPA_Basic");
		
		EntityManager em = enf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// insert 
//		Member member1 = new Member();
//		member1.setId("id");
//		member1.setAge(27);
//		member1.setUserName("jpa1");
//		em.persist(member1);

//		Member member2 = new Member();
//		member2.setId("id2");
//		member2.setAge(28);
//		member2.setUserName("jpa2");
//		em.persist(member2);
	

		
		// select
		Member member1 = em.find(Member.class, "id");
//		System.out.println(member1);
		
		Member member01 = em.find(Member.class, "id");
//		System.out.println(member01);
				
//		System.out.println(member1 == member01);	// true?
		
		
		// JPQL : 엔티티 객체를 대상으로 검색하는 객체 지향 쿼리
//		List<Member> allMembers = em.createQuery("select m from Member m", Member.class).getResultList();
//		System.out.println(allMembers);
		
		// 반환타입 명확할 경우 TypedQuery, 불명확할 경우 Query
//		TypedQuery<Member> typedQuery = em.createQuery("select m from Member m", Member.class);
//		List<Member> allMembers = typedQuery.getResultList();
		
		// 결과로 반환받는 데이터 객체가 정확히 하나일 때 사용 - 없으면 Exception 발생
//		em.createQuery("select m from Member m", Member.class).getSingleResult(); 


		// update: 변경 감지 - 엔터티 조회 및 데이터만 변경하면 자동으로 업데이트 실행됨
		// 모든 맴버변수(필드) set, 업데이트 대상에서 지정되지 않은 맴버변수 데이터는 기존 유지
		
		// 동작 원리
		/*
		 * flush() : 내부 쿼리 저장소에 있는 SQL이 DB에 동기화
		 * 1. flush() <- tx.commit() 호출 시, 자동 호출
		 * 2. Entity snapshot과 변경된 entity를 비교
		 * 3. 변경된 entity가 존재하면 update 쿼리를 생성
		 * 4. 쓰기지연 SQL 저장소 저장
		 * 5. DB 전송 -> DB tx.commit()
		 */
		
		// 영속성 컨택스트를 초기화하는 clear가 먼저 실행되면??
//		em.clear();
		member1.setAge(47);
		
		
		
		// delete
//		em.remove(member1);
		
		
		
		
		em.flush();
//		tx.commit();
	
	}

}
