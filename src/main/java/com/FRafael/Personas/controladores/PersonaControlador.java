package com.FRafael.Personas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRafael.Personas.entidades.Persona;
import com.FRafael.Personas.servicios.PersonaServicio;

@RestController
@RequestMapping("/api/personas")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	@PostMapping(value = "/guardado",consumes = {"application/json","application/xml"})
	public void guardarPersona(@RequestBody Persona persona) {
		personaServicio.guardarPersona(persona);
	}
	
	@GetMapping("/todas")
	public List<Persona> mostrarPersonas(){
		return personaServicio.mostrarPersonas();
	}

}
