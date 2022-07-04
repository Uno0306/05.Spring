package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JPAFinalTest {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = JPA01Connection.connection();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
//			JPA02CRUD.insert(em, 24, "Jackson");
//			JPA02CRUD.insert(em, 2, "Ali");
//			JPA02CRUD.insert(em, 30, "Paster");
//			JPA02CRUD.insert(em, 60, "Endy");
//			JPA02CRUD.insert(em, 25, "Wendy");
			
//			JPA02CRUD.selectById(em, 13245646L);
			
//			JPA02CRUD.updateAge(em, 13245646L, 30);
//			JPA02CRUD.updateName(em, 13245646L, "Jack");
			
//			JPA02CRUD.delete(em, 13245646L);
			
//			JPA02CRUD.selectAll(em);
			JPA02CRUD.selectAllName(em);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			JPA01Connection.close(em, emf);
		}
	}

}
