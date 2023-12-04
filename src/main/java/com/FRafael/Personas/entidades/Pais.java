package com.FRafael.Personas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	public Pais() {
	}

	public Pais(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
