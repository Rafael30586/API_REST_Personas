package com.FRafael.Personas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRafael.Personas.entidades.Pais;
import com.FRafael.Personas.servicios.PaisServicio;

@RestController
@RequestMapping("/api/paises")
public class PaisControlador {
	
	@Autowired
	private PaisServicio paisServicio;
	
	@PostMapping(value = "/guardado",consumes = {"application/json","application/xml"})
	public void guardarPais(@RequestBody Pais pais) {
		paisServicio.guardarPais(pais);
	}
	
	@GetMapping("/todos")
	public List<Pais> mostrarPaises(){
		return paisServicio.mostrarPaises();
	}

}
