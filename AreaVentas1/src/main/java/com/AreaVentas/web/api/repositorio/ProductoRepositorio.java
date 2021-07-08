package com.AreaVentas.web.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaVentas.web.api.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
