package com.FRafael.Personas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FRafael.Personas.entidades.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona,Long>{

}
