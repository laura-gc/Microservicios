package com.areacompras.web.ms.servicio;

import java.util.List;

import com.areacompras.web.ms.modelo.Productos;

public interface ProductosServicio {
	public List<Productos>BuscarTodosProductos();
	public Productos BuscarPorIdProducto(int idProducto);
	
	public Productos crearProducto(Productos productos);
	public Productos editarProducto(Productos productos);
	public void eliminarProducto(int idProducto);
}
