package com.AreaAlmacens.web.api.servicio;

import java.util.List;

import com.AreaAlmacens.web.api.modelo.Cliente;

public interface ClienteServicio {

	public List<Cliente> ListarTodo();
	public Cliente buscarCliente(Long idCliente);
	
	public Cliente crearCliente(Cliente cliente);
	public Cliente editarCliente(Cliente cliente);
	public void eliminarCliente(Long id); 
	 

}
