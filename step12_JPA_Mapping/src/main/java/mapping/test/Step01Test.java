package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;
import step01.entity.Team;

public class Step01Test {

	static void logic(EntityManager em) {
		// Team VS Member ???
		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);
		
		Member member1 = new Member();
		member1.setName("JongHyun");
		member1.setAge(26);
		member1.setTeamId(1L);
		em.persist(member1);
		
		Team team01 = em.find(Team.class, team.getId());
		System.out.println(team01);
		
		Member member01 = em.find(Member.class, member1.getId());
		System.out.println(member01);
		
		
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA_Mapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}	

}
