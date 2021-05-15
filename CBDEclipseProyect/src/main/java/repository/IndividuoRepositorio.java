package repository;

import javax.persistence.EntityManager;

public class IndividuoRepositorio {
	
	static EntityManager em;
	
	public static void createIndividuo() {
		em.getTransaction().begin();
		em.persist(e1);
	}


}
