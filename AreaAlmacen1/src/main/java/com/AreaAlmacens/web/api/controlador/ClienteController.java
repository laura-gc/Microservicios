package com.AreaAlmacens.web.api.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.AreaAlmacens.web.api.modelo.Cliente;
import com.AreaAlmacens.web.api.servicio.ClienteServicio;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

	@Autowired
	private ClienteServicio clienteServicio;
	
	@RequestMapping(value = "/listarCliente",method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarCliente(){
		
		List<Cliente> cliente = new ArrayList<>();
		
		cliente = clienteServicio.ListarTodo();
		
		
		if (cliente.isEmpty()) {
			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping(value = "buscarCliente/{idCliente}")
	public ResponseEntity<Cliente> buscarCliente (@PathVariable("idCliente") Long idCliente){
		
		Cliente cliente= clienteServicio.buscarCliente(idCliente);
		
		if (null==cliente) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> crearCliente(@Validated @RequestBody Cliente cliente,BindingResult result){
		
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Cliente clienteCrear= clienteServicio.crearCliente(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteCrear);
	}
	
	@PutMapping(value = "editarCliente/{idCliente}")
	public ResponseEntity<Cliente> editarCliente(@PathVariable("idCliente") Long idCliente, @RequestBody Cliente cliente){
		
		cliente.setIdCliente(idCliente);
		
		Cliente clienteDB = clienteServicio.editarCliente(cliente);
		
		if (clienteDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clienteDB);
	}
	
	@DeleteMapping(value = "eliminarCliente/{idCliente}")
	public void eliminarCliente(@PathVariable("idCliente")Long idCliente){
		
		clienteServicio.eliminarCliente(idCliente);
	}
}
