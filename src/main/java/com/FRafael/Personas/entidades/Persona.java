package com.FRafael.Personas.entidades;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

//import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long documento;
	private String nombres;
	private String apellidos;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate nacimiento;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@ManyToOne
	private Pais pais_de_origen;

	public Persona() {
	}

	

	public Persona(Long documento, String nombres, String apellidos, LocalDate nacimiento, Genero genero,
			Pais pais_de_origen) {
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.genero = genero;
		this.pais_de_origen = pais_de_origen;
	}

	public Long getDocumento() {
		return documento;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Pais getPais_de_origen() {
		return pais_de_origen;
	}


	public void setPais_de_origen(Pais pais_de_origen) {
		this.pais_de_origen = pais_de_origen;
	}

	@Override
	public String toString() {
		return "Persona [documento=" + documento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", nacimiento="
				+ nacimiento + ", genero=" + genero + ", pais_de_origen=" + pais_de_origen + "]";
	}
	
}

enum Genero{
	MASCULINO,
	FEMENINO
}
