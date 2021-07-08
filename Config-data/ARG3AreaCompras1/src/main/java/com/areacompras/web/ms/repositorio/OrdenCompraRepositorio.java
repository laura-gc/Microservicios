package com.areacompras.web.ms.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.areacompras.web.ms.modelo.Empleados;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Proveedores;

public interface OrdenCompraRepositorio extends JpaRepository<OrdenCompra, Integer>{
	//Metodo que permite buscar por Empleados
	//Dentro de la tabla OrdenCompra
	public List<OrdenCompra> findByEmpleados(Empleados empleados);
	
	//Metodo que permite buscar por Proveedores
	//Dentro de la tabla OrdenCompra
	public List<OrdenCompra> findByProveedores(Proveedores proveedores);
}
