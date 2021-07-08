package com.areacompras.web.ms.servicio;

import java.util.List;

import com.areacompras.web.ms.modelo.DetalleOrdenCompra;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Productos;

public interface DetalleOrdenCompraServicio {
	public List<DetalleOrdenCompra>BuscarTodosDetalleOrdenCompra();
	public DetalleOrdenCompra BuscarPorIdDetalleOrdenCompra(int idDetalleOrdenCompra);
	
	public DetalleOrdenCompra crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra);
	public DetalleOrdenCompra editarDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra);
	public void eliminarDetalleOrdenCompra(int idDetalleOrdenCompra);
	
	public List<DetalleOrdenCompra> findByOrdenCompra(OrdenCompra ordenCompra);
	public List<DetalleOrdenCompra> findByProductos(Productos productos);
}
