package com.areacompras.web.ms.controlador;

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

import com.areacompras.web.ms.modelo.Proveedores;
import com.areacompras.web.ms.servicio.ProveedoresServicio;

@RestController
@RequestMapping(value = "proveedores")
public class ProveedoresControlador {
	
	@Autowired
	private ProveedoresServicio proveedoresServicio;
	
	@RequestMapping(value = "/listarProveedores",method = RequestMethod.GET)
	public ResponseEntity<List<Proveedores>>listarProveedores(){
		List<Proveedores> proveedores=new ArrayList<>();
		
		proveedores=proveedoresServicio.BuscarTodosProveedores();
		if (proveedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(proveedores);
	}
	
	@GetMapping(value = "buscarProveedor/{idProveedor}")
	public ResponseEntity<Proveedores> buscarProveedor(@PathVariable("idProveedor")Integer idProveedor){
		Proveedores proveedores=proveedoresServicio.BuscarPorIdProveedor(idProveedor);
		if (null==proveedores) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedores);
	}
	
	@PostMapping
	public ResponseEntity<Proveedores> crearProveedor(@Validated @RequestBody Proveedores proveedores,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);//this.formatMessage(
		}
		Proveedores proveedorCrear=proveedoresServicio.crearProveedor(proveedores);
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorCrear);
	}
	
	@PutMapping(value = "editarProveedor/{idProveedor}")
	public ResponseEntity<Proveedores> editarProveedor(@PathVariable("idProveedor")Integer idProveedor,
			@RequestBody Proveedores proveedores){
		proveedores.setIdProveedor(idProveedor);
		Proveedores proveedorDB=proveedoresServicio.editarProveedor(proveedores);
		if (proveedorDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(proveedorDB);
	}
	
	@DeleteMapping(value = "eliminarProveedor/{idProveedor}")
	public void eliminarProveedor(@PathVariable("idProveedor")Integer idProveedor){
		proveedoresServicio.eliminarProveedor(idProveedor);
	}
}
