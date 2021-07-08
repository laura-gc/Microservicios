package com.AreaAlmacens.web.api.servicio;

import java.util.List;

import com.AreaAlmacens.web.api.modelo.DocDetalleVenta;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Producto;

public interface DocDetalleVentaServicio {

	public List<DocDetalleVenta> listarTodo();
	public DocDetalleVenta BuscarPorIdDocDetalleVenta(Long idDocDetalleVenta);
	
	public DocDetalleVenta crearDocDetalleVenta(DocDetalleVenta docDetalleVenta);
	public DocDetalleVenta editarDocDetalleVenta(DocDetalleVenta docDetalleVenta);
	public void eliminarDocDetalleVenta(Long idDocDetalleVenta);
	
	public List<DocDetalleVenta> findByProducto(Producto producto);
	public List<DocDetalleVenta> findByDocVenta(DocVenta docVenta);
}
