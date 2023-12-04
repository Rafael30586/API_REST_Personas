package com.FRafael.Personas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FRafael.Personas.entidades.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais,Long>{

}
