package objectDbCBD.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Planeta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String descripcion;
	
	@ManyToMany(targetEntity=Planeta.class,	mappedBy="esHabitadoPor")
	private List<Individuo> individuos;

	public Planeta(String nombre, String descripcion, List<Individuo> individuos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.individuos = individuos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", individuos="
				+ individuos + "]";
	}
}
