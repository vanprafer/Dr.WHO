package objectDbCBD.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	@ManyToMany(targetEntity=Planeta.class,	mappedBy="habitaEn")
	private List<Planeta> planetas;
	
	@OneToMany(mappedBy="usa", cascade=CascadeType.PERSIST,	fetch=FetchType.LAZY)
	private List<Tecnologia> tecnologias;
	
	public Individuo(String nombre, Especie especie, Integer numCorazones, Organismo organismo,
			String descripcion, List<Planeta> planetas, List<Tecnologia> tecnologias) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.numCorazones = numCorazones;
		this.organismo = organismo;
		this.descripcion = descripcion;
		this.planetas = planetas;
		this.tecnologias = tecnologias;
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

	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}

	public List<Tecnologia> getTecnologia() {
		return tecnologias;
	}
	
	public void setTecnologias(List<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

	@Override
	public String toString() {
		return "Individuo [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", numCorazones=" + numCorazones
				+ ", organismo=" + organismo + ", descripcion=" + descripcion + "]";
	}
}
