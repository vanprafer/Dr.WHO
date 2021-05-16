package objectDbCBD.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Individuo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private Especie especie;
	private Integer numCorazones;
	private Organismo organismo;
	private String descripcion;	
	
	@ManyToMany(targetEntity=Planeta.class,	cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Planeta> habita;
	
	@OneToMany(cascade=CascadeType.PERSIST,	fetch=FetchType.LAZY)
	private List<Tecnologia> esUsado;
	
	public Individuo(String nombre, Especie especie, Integer numCorazones, Organismo organismo,
			String descripcion, List<Planeta> habita, List<Tecnologia> esUsado) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.numCorazones = numCorazones;
		this.organismo = organismo;
		this.descripcion = descripcion;
		this.habita = habita;
		this.esUsado = esUsado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Especie getEspecie() {
		return especie;
	}

	public Integer getNumCorazones() {
		return numCorazones;
	}

	public Organismo getOrganismo() {
		return organismo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Tecnologia> getEsUsado() {
		return esUsado;
	}
	
	public void setEsUsado(List<Tecnologia> esUsado) {
		this.esUsado = esUsado;
	}
	
	public List<Planeta> getHabita() {
		return habita;
	}

	public void setHabita(List<Planeta> habita) {
		this.habita = habita;
	}

	public long getId() {
		return id;
	}

	public void setNumCorazones(Integer numCorazones) {
		this.numCorazones = numCorazones;
	}

	public void setOrganismo(Organismo organismo) {
		this.organismo = organismo;
	}

	@Override
	public String toString() {
		return "Individuo [nombre=" + nombre + ", especie=" + especie + ", numCorazones=" + numCorazones
				+ ", organismo=" + organismo + ", descripcion=" + descripcion + "]";
	}
}
