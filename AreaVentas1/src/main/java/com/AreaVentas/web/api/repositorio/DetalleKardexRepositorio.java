package com.AreaVentas.web.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaVentas.web.api.modelo.DetalleKardex;
import com.AreaVentas.web.api.modelo.Kardex;
import com.AreaVentas.web.api.modelo.Producto; 

@Repository
public interface DetalleKardexRepositorio extends JpaRepository<DetalleKardex, Long> {

	public List<DetalleKardex> findByKardex(Kardex Kardex);
	
	public List<DetalleKardex> findByProducto(Producto producto); 
}
