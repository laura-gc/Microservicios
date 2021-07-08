package com.areacompras.web.ms.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.areacompras.web.ms.modelo.Productos;

public interface ProductosRepositorio extends JpaRepository<Productos, Integer>{

}
