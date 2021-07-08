package com.AreaAlmacens.web.api.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaAlmacens.web.api.modelo.Cliente;
import com.AreaAlmacens.web.api.repositorio.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicioImplementa implements ClienteServicio {

	private final ClienteRepositorio clienteRepositorio;
	  
	@Override
	public List<Cliente> ListarTodo() {
		
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente buscarCliente(Long idCliente) {
		
		return clienteRepositorio.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
       
		
		cliente.setFechaRegistro(new Date());
		
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente editarCliente(Cliente cliente) {
		
		Cliente clienteDB= buscarCliente(cliente.getIdCliente());
		
		if (null == clienteDB) {
			return null;
		}
		
		clienteDB.setNombre(cliente.getNombre());
		clienteDB.setDocIdentidad(cliente.getDocIdentidad());
		clienteDB.setTelefono(cliente.getTelefono());
		clienteDB.setCorreo(cliente.getCorreo());
		clienteDB.setDireccion(cliente.getDireccion());
		 
		return clienteRepositorio.save(clienteDB);
	}

	@Override
	public void eliminarCliente(Long id) {
		
		clienteRepositorio.deleteById(id); 
		
	}

}
