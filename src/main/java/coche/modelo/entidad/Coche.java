package coche.modelo.entidad;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//Anotaciones de Spring
@Component
@Scope("prototype")
//Anotaciones de JPA
@Entity
@Table(name="coche")
public class Coche {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="matricula",unique=true)
	private String matricula;
	private String marca;
	private String modelo;
	private int km;
	 
	public Coche() {
		super();
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	} 

	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", km=" + km
				+ "]";
	}

	 
}
