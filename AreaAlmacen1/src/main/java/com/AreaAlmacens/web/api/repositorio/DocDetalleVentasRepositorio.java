package com.AreaAlmacens.web.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaAlmacens.web.api.modelo.DocDetalleVenta;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Producto;

@Repository 
public interface DocDetalleVentasRepositorio extends JpaRepository<DocDetalleVenta, Long> {

	public List<DocDetalleVenta> findByProducto(Producto producto);
	 
	public List<DocDetalleVenta> findByDocVenta(DocVenta docVenta);
}
