package com.FRafael.Personas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRafael.Personas.entidades.Persona;
import com.FRafael.Personas.repositorios.PersonaRepositorio;

@Service
public class PersonaServicio {
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	public void guardarPersona(Persona persona) {
		personaRepositorio.save(persona);
	}
	
	public List<Persona> mostrarPersonas(){
		return personaRepositorio.findAll();
	}
	
	public void borrarPersona(Long dni) {
		personaRepositorio.deleteById(dni);
	}
	
	public Persona obtenerPersonaId(Long dni) {
		Persona persona = personaRepositorio.getReferenceById(dni);
		return persona;
	}

}
