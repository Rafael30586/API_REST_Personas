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
	
	public void borrarPersona(Long id) {
		personaRepositorio.deleteById(id);
	}
	
	public Persona obtenerPersonaId(Long id) {
		Persona persona = personaRepositorio.getReferenceById(id);
		return persona;
	}

}
