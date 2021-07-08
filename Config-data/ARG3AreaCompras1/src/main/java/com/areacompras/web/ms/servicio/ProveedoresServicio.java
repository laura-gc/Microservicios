package com.areacompras.web.ms.servicio;

import java.util.List;

import com.areacompras.web.ms.modelo.Proveedores;

public interface ProveedoresServicio {
	public List<Proveedores>BuscarTodosProveedores();
	public Proveedores BuscarPorIdProveedor(int idProveedor);
	
	public Proveedores crearProveedor(Proveedores proveedores);
	public Proveedores editarProveedor(Proveedores proveedores);
	public void eliminarProveedor(int idProveedor);
}
