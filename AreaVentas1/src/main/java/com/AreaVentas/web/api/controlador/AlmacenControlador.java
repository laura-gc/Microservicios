package com.AreaVentas.web.api.controlador;

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

import com.AreaVentas.web.api.modelo.Almacen;
import com.AreaVentas.web.api.servicio.AlmacenServicio;

@RestController
@RequestMapping(value = "/Almacen") 
public class AlmacenControlador {

	@Autowired
	private AlmacenServicio almacenServicio;
	
	@RequestMapping(value = "/listarAlmacen",method = RequestMethod.GET)
	public ResponseEntity<List<Almacen>>listarAlmacen(){
		
		List<Almacen> almacen =new ArrayList<>();
		
		almacen = almacenServicio.listarTodos();
		
		if (almacen.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(almacen);
	}
	
	@GetMapping(value = "buscarAlmacen/{idAlmacen}")
	public ResponseEntity<Almacen> buscarAlmacen(@PathVariable("idAlmacen")Long idAlmacen){
		
		Almacen almacen = almacenServicio.BuscarPorIdAlmacen(idAlmacen);
		
		if (null==almacen) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(almacen);
	}
	
	@PostMapping
	public ResponseEntity<Almacen> crearAlmacen(@Validated @RequestBody Almacen almacen,
			BindingResult result){
		
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Almacen almacenCrear  = almacenServicio.crearAlmacen(almacen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(almacenCrear);
	}
	
	@PutMapping(value = "editarAlmacen/{idAlmacen}")
	public ResponseEntity<Almacen> editarAlmacen(@PathVariable("idAlmacen")Long idAlmacen,
			@RequestBody Almacen almacen){
		
		almacen.setIdalmacen(idAlmacen);
		
		Almacen almacenDB= almacenServicio.editarAlmacen(almacen);
		
		if (almacenDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(almacenDB);
	}
	
	@DeleteMapping(value = "eliminarAlmacen/{idAlmacen}")
	public void eliminarAlmacen(@PathVariable("idAlmacen")Long idAlmacen){
		
		almacenServicio.eliminarAlmacen(idAlmacen); 
	}
}
