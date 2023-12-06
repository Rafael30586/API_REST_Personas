package com.FRafael.Personas.controladores;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private PaisServicio paisServicio;
	
	@PostMapping(value = "/guardado",consumes = {"application/json","application/xml"})
	public void guardarPersona(@RequestBody Persona persona) {
		personaServicio.guardarPersona(persona);
	}
	
	@GetMapping("/todas")
	public List<Persona> mostrarPersonas(){
		return personaServicio.mostrarPersonas();
	}
	
	@DeleteMapping("/borrado")
	public void borrarPersona(@RequestParam Long id) {
		personaServicio.borrarPersona(id);
	}
	
	@PutMapping(value = "/edicion",consumes = {"application/json","application/xml"})
	public void editarPersona(@RequestParam Long dni,@RequestBody Persona persona) {
		
		Persona p = personaServicio.obtenerPersona(dni);
		
		personaServicio.borrarPersona(dni);
		
		p.setDocumento(dni);
		p.setNombres(persona.getNombres());
		p.setApellidos(persona.getApellidos());
		p.setGenero(persona.getGenero());
		p.setNacimiento(persona.getNacimiento());
		p.setPais_de_origen(persona.getPais_de_origen());
		
		personaServicio.guardarPersona(p);
	}
	
	@PutMapping(value = "/cambio-de-nombres/{dni}")
	public void cambiarNombres(@PathVariable Long dni, @RequestParam String nombres) {
		
		Persona p = personaServicio.obtenerPersona(dni);
		p.setNombres(nombres);
		personaServicio.guardarPersona(p);
	}
	
	@PutMapping(value = "/cambio-de-apellidos/{dni}")
	public void cambiarApellidos(@PathVariable Long dni, @RequestParam String apellidos) {
		
		Persona p = personaServicio.obtenerPersona(dni);
		p.setApellidos(apellidos);
		personaServicio.guardarPersona(p);
	}
	
	@PutMapping(value = "/cambio-de-genero/{dni}")
	public void cambiarGenero(@PathVariable Long dni, @RequestParam char genero) {
		
		Genero1 genero1;
		Persona p = personaServicio.obtenerPersona(dni);
		
		switch(genero) {
		case 'm': genero1 = Genero1.MASCULINO;
		p.setGenero(genero1);break;
		case 'f': genero1 = Genero1.FEMENINO;
		p.setGenero(genero1);break;
		}
		
		if(genero=='m'||genero=='f') {
			personaServicio.guardarPersona(p); 
		}
	}
	
	@PutMapping(value = "/cambio-de-pais-de-origen/{dni}")
	public void cambiarPais(@PathVariable Long dni,@RequestParam Long idPais) {
		Pais pais = paisServicio.obtenerPaisId(idPais);
		Persona p = personaServicio.obtenerPersona(dni);
		p.setPais_de_origen(pais);
		personaServicio.guardarPersona(p);
	}
	
	@PutMapping(value = "/cambio-de-fecha-de-nacimiento/{dni}")
	public void cambiarNacimiento(@PathVariable Long dni,@RequestParam int anio, 
			@RequestParam int mesNumero,@RequestParam int dia) {
		
		Month mes;
		LocalDate fechaNacimiento; 
		Persona p = personaServicio.obtenerPersona(dni);
		
		switch(mesNumero) {
		case 1: mes = Month.JANUARY;
		fechaNacimiento =  LocalDate.of(anio, mes, dia); 
		p.setNacimiento(fechaNacimiento);break;
		case 2: mes = Month.FEBRUARY;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 3: mes = Month.MAY;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 4: mes = Month.APRIL;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 5: mes = Month.MAY;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 6: mes = Month.JUNE;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 7: mes = Month.JULY;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 8: mes = Month.AUGUST;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 9: mes = Month.SEPTEMBER;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 10: mes = Month.OCTOBER;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 11: mes = Month.NOVEMBER;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		case 12: mes = Month.DECEMBER;
		fechaNacimiento =  LocalDate.of(anio, mes, dia);
		p.setNacimiento(fechaNacimiento);break;
		default: fechaNacimiento = null;
		}
	
		personaServicio.guardarPersona(p);
	}
}
