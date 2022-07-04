package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA01Connection {
	
	public static EntityManagerFactory connection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step11_JPA_Practice");
		return emf;
	}
	
	public static void commit(EntityTransaction tx) {
		tx.commit();
	}

	public static void close(EntityManager em, EntityManagerFactory emf) {
		em.close(); 
		emf.close();
	}
}
