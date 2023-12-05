package com.FRafael.Personas.servicios;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRafael.Personas.entidades.Pais;
import com.FRafael.Personas.repositorios.PaisRepositorio;

@Service
public class PaisServicio {
	
	@Autowired
	private PaisRepositorio paisRepositorio;
	
	public void guardarPais(Pais pais) {
		paisRepositorio.save(pais);
	}
	
	public List<Pais> mostrarPaises(){
		return paisRepositorio.findAll();
	}
	
	public void borrarPais(Long id) {
		paisRepositorio.deleteById(id);
	}
	
	public Pais obtenerPaisId(Long id) {
		Pais pais = paisRepositorio.getReferenceById(id);
		return pais;
	}

}
