package com.AreaAlmacens.web.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaAlmacens.web.api.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
