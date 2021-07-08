package com.areacompras.web.ms.servicio;

import java.util.List;

import com.areacompras.web.ms.modelo.Empleados;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Proveedores;

public interface OrdenCompraServicio {
	public List<OrdenCompra>BuscarTodosOrdenCompra();
	public OrdenCompra BuscarPorIdOrdenCompra(int idOrdenCompra);
	
	public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra);
	public OrdenCompra editarOrdenCompra(OrdenCompra ordenCompra);
	public void eliminarOrdenCompra(int idOrdenCompra);
	
	public List<OrdenCompra> findByEmpleados(Empleados empleados);
	public List<OrdenCompra> findByProveedores(Proveedores proveedores);
}
