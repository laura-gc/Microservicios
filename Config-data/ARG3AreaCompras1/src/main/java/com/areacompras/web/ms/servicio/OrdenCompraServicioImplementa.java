package com.areacompras.web.ms.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.areacompras.web.ms.modelo.Empleados;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Proveedores;
import com.areacompras.web.ms.repositorio.OrdenCompraRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraServicioImplementa implements OrdenCompraServicio{
	
	private final OrdenCompraRepositorio ordenCompraRepositorio;
	
	@Override
	public List<OrdenCompra> BuscarTodosOrdenCompra() {
		return ordenCompraRepositorio.findAll();
	}

	@Override
	public OrdenCompra BuscarPorIdOrdenCompra(int idOrdenCompra) {
		return ordenCompraRepositorio.findById(idOrdenCompra).orElse(null);
	}

	@Override
	public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra) {
		ordenCompra.setFechaCompra(new Date());
		
		return ordenCompraRepositorio.save(ordenCompra);
	}

	@Override
	public OrdenCompra editarOrdenCompra(OrdenCompra ordenCompra) {
		OrdenCompra ordenCompraDB=BuscarPorIdOrdenCompra(ordenCompra.getIdOrdenCompra());
		if (null == ordenCompraDB) {
			return null;
		}
		ordenCompraDB.setDescripcion(ordenCompra.getDescripcion());
		//ordenCompraDB.setFechaCompra(ordenCompra.getFechaCompra());
		ordenCompraDB.setEmpleados(ordenCompra.getEmpleados());
		ordenCompraDB.setProveedores(ordenCompra.getProveedores());
		return ordenCompraRepositorio.save(ordenCompraDB);
	}

	@Override
	public void eliminarOrdenCompra(int idOrdenCompra) {
		ordenCompraRepositorio.deleteById(idOrdenCompra);
	}

	@Override
	public List<OrdenCompra> findByEmpleados(Empleados empleados) {
		return ordenCompraRepositorio.findByEmpleados(empleados);
	}

	@Override
	public List<OrdenCompra> findByProveedores(Proveedores proveedores) {
		return ordenCompraRepositorio.findByProveedores(proveedores);
	}

}
