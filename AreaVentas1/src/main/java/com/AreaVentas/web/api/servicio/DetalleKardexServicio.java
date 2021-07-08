package com.AreaVentas.web.api.servicio;

import java.util.List;

import com.AreaVentas.web.api.modelo.DetalleKardex;
import com.AreaVentas.web.api.modelo.Kardex;
import com.AreaVentas.web.api.modelo.Producto;

public interface DetalleKardexServicio { 
 
	
	public List<DetalleKardex> ListarTodos();
	public DetalleKardex BuscarPorIdDetalleKardex(Long iddetallekardex);
	
	public DetalleKardex crearDetalleKardex(DetalleKardex detalleKardex);
	public DetalleKardex editarDetalleKardexCompra(DetalleKardex detalleKardex);
	public void eliminarDetalleKardex(Long iddetallekardex); 
	
	public List<DetalleKardex> findByKardex(Kardex Kardex);
	public List<DetalleKardex> findByProducto(Producto producto);  
}

 