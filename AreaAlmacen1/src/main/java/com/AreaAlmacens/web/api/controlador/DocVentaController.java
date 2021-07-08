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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.AreaAlmacens.web.api.modelo.Cliente;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Empleado;
import com.AreaAlmacens.web.api.servicio.DocVentaServicio;

@RestController
@RequestMapping(value = "docVenta")
public class DocVentaController {

	@Autowired
	private DocVentaServicio docVentaServicio;
		
	@RequestMapping(value = "/listarDocVenta", method = RequestMethod.GET)
	public ResponseEntity<List<DocVenta>> listarDocVenta(@RequestParam(name = "ClienteId",
	required = false) Long ClienteId,@RequestParam(name = "EmpleadoId",required = false)Long EmpleadoId) {
		
		List<DocVenta> docVenta = new ArrayList<>();
		
		if(null == ClienteId && null == EmpleadoId) {
			
			docVenta = docVentaServicio.ListarTodo();
			  
			if(docVenta.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			docVenta = docVentaServicio.findByCliente(Cliente.builder().idCliente(ClienteId).build());
			docVenta = docVentaServicio.findByEmpleado(Empleado.builder().idEmpleado(EmpleadoId).build());
			
			if(docVenta.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(docVenta);
	}
	
	@GetMapping(value = "buscarDocVenta/{idDocVenta}")
	public ResponseEntity<DocVenta> getDocVenta(@PathVariable("idDocVenta")Long idDocVenta){
		
		DocVenta docVenta  = docVentaServicio.BuscarPorIdDocVenta(idDocVenta);
		
		if (null==docVenta) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(docVenta);
	} 
	
	@PostMapping
	public ResponseEntity<DocVenta> crearDocVenta(@Validated @RequestBody DocVenta docVenta,
			BindingResult result){
		
		if (result.hasErrors()) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		DocVenta docVentaCrear = docVentaServicio.crearDocVenta(docVenta);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(docVentaCrear);
	}
	
	@PutMapping(value = "editarDocVenta/{idDocVenta}")
	public ResponseEntity<DocVenta> editarDocVenta(@PathVariable("idDocVenta")Long idDocVenta,
			@RequestBody DocVenta docVenta){
		
		docVenta.setIdDocVenta(idDocVenta);
		
		DocVenta docVentaDB = docVentaServicio.editarDocVenta(docVenta);
		
		if (docVentaDB == null) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(docVentaDB); 
	}
	
	@DeleteMapping(value = "eliminarDocVenta/{idDocVenta}")
	public void eliminarDocVenta(@PathVariable("idDocVenta")Long idDocVenta){
		
		docVentaServicio.eliminarDocVenta(idDocVenta); 
	}
}
