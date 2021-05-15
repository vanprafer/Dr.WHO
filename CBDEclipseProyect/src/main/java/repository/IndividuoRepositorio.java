package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import objectDbCBD.Models.Especie;
import objectDbCBD.Models.Individuo;
import objectDbCBD.Models.Organismo;
import objectDbCBD.Models.Planeta;
import objectDbCBD.Models.Tecnologia;

public class IndividuoRepositorio {
	
	public static EntityManager em;
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("‪C:\\Users\\Vanessa\\Desktop\\DataBase.odb");
	
	
	public static Individuo createIndividuo(String nombre, Especie especie, Integer numCorazones, Organismo organismo, 
			String descripcion, List<Planeta> habita, List<Tecnologia> esUsado) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Individuo ind = new Individuo(nombre, especie, numCorazones, organismo, descripcion, habita, esUsado);
		
		em.persist(ind);
		em.getTransaction().commit();
		return ind;	
	}
	
	public static Individuo getIndividuoPorNombre(String nombre) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Individuo> query = em.createQuery("select i From Individuo i where i.nombre = " +nombre, Individuo.class);
		Individuo individuo = query.getSingleResult();
		
		return individuo;
	}


}
