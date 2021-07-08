package com.AreaVentas.web.api.servicio;

import java.util.List;

import com.AreaVentas.web.api.modelo.Producto;

public interface ProductoServicio {

	public List<Producto>BuscarTodos();
	public Producto BuscarPorIdProducto(Long idProducto);
	
	public Producto crearProducto(Producto productos);
	public Producto editarProducto(Producto productos);
	public void eliminarProducto(Long idProducto); 
    
}
