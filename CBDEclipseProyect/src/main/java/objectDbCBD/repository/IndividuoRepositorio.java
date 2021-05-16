package objectDbCBD.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import objectDbCBD.Configuracion;
import objectDbCBD.Models.Especie;
import objectDbCBD.Models.Individuo;
import objectDbCBD.Models.Organismo;
import objectDbCBD.Models.Planeta;
import objectDbCBD.Models.Tecnologia;

public class IndividuoRepositorio {
	
	public static EntityManager em;
	
	public static Individuo createIndividuo(String nombre, Especie especie, Integer numCorazones, Organismo organismo,
			String descripcion, List<Planeta> habita, List<Tecnologia> esUsado) {
		
		em = Configuracion.em;
		em.getTransaction().begin();
		
		Individuo e1 = new Individuo(nombre, especie, numCorazones, organismo, descripcion, habita, esUsado);
		
		em.persist(e1);
		em.getTransaction().commit();
		return e1;	
	}
	
	public static List<Individuo> listIndividuos(){
		List<Individuo> individuos = new ArrayList<Individuo>();
		em = Configuracion.em;
		
		TypedQuery<Individuo> queryP6 = em.createQuery("select i From Individuo i", Individuo.class);
		individuos = queryP6.getResultList();
		return individuos;	
	}
	
	public static void deleteIndividuo(String idIndividuo) {
		em = Configuracion.em;
		em.getTransaction().begin();
		
		TypedQuery<Individuo> query = em.createQuery("select p From Individuo p where p.id = " +idIndividuo, Individuo.class);
		Individuo individuo = query.getSingleResult();
		
		em.remove(individuo);
		em.getTransaction().commit();
	}
	
	public static Individuo updateIndividuo(String idIndividuo, String nombre, Integer numCorazones, Organismo organismo,
			String descripcion, List<Planeta> habita, List<Tecnologia> esUsado) {
		em = Configuracion.em;
		em.getTransaction().begin();
		
		TypedQuery<Individuo> query = em.createQuery("select p From Individuo p where p.id = " +idIndividuo, Individuo.class);
		Individuo individuo = query.getSingleResult();
		
		individuo.setNombre(nombre);
		individuo.setNumCorazones(numCorazones);
		individuo.setOrganismo(organismo);
		individuo.setDescripcion(descripcion);
		individuo.setHabita(habita);
		individuo.setEsUsado(esUsado);
		
		em.persist(individuo);
		em.getTransaction().commit();
		return individuo;	
	}
	
	public static Individuo showIndividuo(String id) {
		em = Configuracion.em;
		
		TypedQuery<Individuo> query = em.createQuery("select p From Individuo p where p.id = " +id, Individuo.class);
		Individuo individuo = query.getSingleResult();
		return individuo;
	}
}
