package com.AreaAlmacens.web.api.servicio;

import java.util.List;

import com.AreaAlmacens.web.api.modelo.Cliente;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Empleado;

public interface DocVentaServicio {

	public List<DocVenta>  ListarTodo();
	public DocVenta BuscarPorIdDocVenta(Long idDocVenta);
	 
	public DocVenta crearDocVenta (DocVenta docVenta);
	public DocVenta editarDocVenta(DocVenta docVenta);
	public void eliminarDocVenta(Long idDocVenta);
	  
	public List<DocVenta> findByEmpleado(Empleado empleados);
	public List<DocVenta> findByCliente(Cliente cliente);
}
