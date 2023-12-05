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
	
	@DeleteMapping("/borrado-por-id")
	public void borrarPersona(@RequestParam Long id) {
		personaServicio.borrarPersona(id);
	}
	
	@PutMapping //En lugar de un LacalDate, aceptar 3 int como parametro para mes, dia y año
	public void modificarPersona(@RequestParam Long id,@RequestParam Long documento,
			@RequestParam String nombres, @RequestParam String apellidos,@RequestParam LocalDate nacimiento,
			@RequestParam Genero1 genero,@RequestParam Long paisId) {
		
		Persona persona = personaServicio.obtenerPersonaId(id);
		Pais pais = paisServicio.obtenerPaisId(paisId);
		
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setDocumento(documento);
		persona.setGenero(genero);
		persona.setNacimiento(nacimiento);
		persona.setPais_de_origen(pais);
	}

}
