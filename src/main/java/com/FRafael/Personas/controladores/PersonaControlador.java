package com.FRafael.Personas.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRafael.Personas.entidades.Genero1;
import com.FRafael.Personas.entidades.Pais;
import com.FRafael.Personas.entidades.Persona;
import com.FRafael.Personas.servicios.PaisServicio;
import com.FRafael.Personas.servicios.PersonaServicio;

@RestController
@RequestMapping("/api/personas")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	private PaisServicio paisServicio;
	
	@PostMapping(value = "/guardado",consumes = {"application/json","application/xml"})
	public void guardarPersona(@RequestBody Persona persona) {
		personaServicio.guardarPersona(persona);
	}
	
	@GetMapping("/todas")
	public List<Persona> mostrarPersonas(){
		return personaServicio.mostrarPersonas();
	}
	
	@DeleteMapping("/borrado-por-dni")
	public void borrarPersona(@RequestParam Long id) {
		personaServicio.borrarPersona(id);
	}
	
	@PutMapping(value = "/edicion",consumes = {"application/json","application/xml"})
	public void editarPersona(@RequestParam Long dni,@RequestBody Persona persona) {
		
		Persona p = personaServicio.obtenerPersonaId(dni);
		
		personaServicio.borrarPersona(dni);
		
		p.setDocumento(dni);
		p.setNombres(persona.getNombres());
		p.setApellidos(persona.getApellidos());
		p.setGenero(persona.getGenero());
		p.setNacimiento(persona.getNacimiento());
		p.setPais_de_origen(persona.getPais_de_origen());
		
		personaServicio.guardarPersona(p);
	}
}
