package mapping.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step03.entity.Member;
import step03.entity.Team;

public class Step03Test {

	static void logic(EntityManager em) {
		
		// Team VS Member ???

		/* step03.entity */
		Team teamA = new Team();
		teamA.setName("TeamA");
		em.persist(teamA);

		Team teamB = new Team();
		teamB.setName("TeamB");
		em.persist(teamB);
		
		Member member1 = new Member();
		member1.setName("JongHeon");
		member1.setAge(26);
		member1.setTeam(teamA);
		em.persist(member1);
		
		teamA.getMembers().add(member1);
		
		Member member2 = new Member();
		member2.setName("DoHeon");
		member2.setAge(25);
		member2.setTeam(teamB);
		em.persist(member2);
		
		teamB.getMembers().add(member2);

		
		Member member01 = em.find(Member.class, member1.getId());
		System.out.println(member01);
		
		Team team01 = em.find(Team.class, teamA.getId());
		System.out.println(team01);
		System.out.println(team01.getMembers());
		
//		Member member02 = em.find(Member.class, member2.getId());
//		System.out.println(member02);
//
//		Team team02 = em.find(Team.class, teamB.getId());
//		System.out.println(team02);
//		System.out.println(team02.getMembers());

		List<Member> members = new ArrayList<Member>();
		Member member3 = new Member();
		member3.setName("SungJun");
		member3.setAge(26);
		member3.setTeam(teamB);
		members.add(member3);
		
		team01.setMembers(members);
		em.persist(team01);
		System.out.println(team01.getMembers());
		
		
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
