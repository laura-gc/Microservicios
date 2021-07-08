package com.areacompras.web.ms.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.areacompras.web.ms.modelo.DetalleOrdenCompra;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Productos;

public interface DetalleOrdenCompraRepositorio extends JpaRepository<DetalleOrdenCompra, Integer>{
	//Metodo que permite buscar por ordenCompra
	//Dentro de la tabla DetalleOrdenCompra
	public List<DetalleOrdenCompra> findByOrdenCompra(OrdenCompra ordenCompra);
	
	//Metodo que permite buscar por Productos
	//Dentro de la tabla DetalleOrdenCompra
	public List<DetalleOrdenCompra> findByProductos(Productos productos);
}
