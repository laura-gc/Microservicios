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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.AreaVentas.web.api.modelo.Almacen;
import com.AreaVentas.web.api.modelo.Kardex;
import com.AreaVentas.web.api.servicio.KardexServicio;

@RestController
@RequestMapping(value = "/Kardex") 
public class KardexController {
 

	@Autowired
	private KardexServicio kardexServicio;
		
	@RequestMapping(value = "/listarKardex", method = RequestMethod.GET)
	public ResponseEntity<List<Kardex>> listarKardex(@RequestParam(name = "AlmacenId",
	required = false) Long AlmacenId) {
		
		List<Kardex> kardex = new ArrayList<>();
		 
		if(null == AlmacenId) {
			
			kardex = kardexServicio.BuscarTodos();
			
			if(kardex.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			kardex = kardexServicio.findByAlmacen(Almacen.builder().idalmacen(AlmacenId).build()); 
		
			if(kardex.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(kardex); 
	}
	
	@GetMapping(value = "buscarKardex/{idKardex}")
	public ResponseEntity<Kardex> getKardex(@PathVariable("idKardex")Long idKardex){
		
		Kardex kardex= kardexServicio.BuscarPorIdKardex(idKardex);
		
		if (null==kardex) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(kardex);
	}
	
	@PostMapping
	public ResponseEntity<Kardex> crearKardex(@Validated @RequestBody Kardex kardex, BindingResult result){
		
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Kardex kardexCrear = kardexServicio.crearKardex(kardex);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(kardexCrear);
	} 
	
	@PutMapping(value = "editarKardex/{idKardex}")
	public ResponseEntity<Kardex> editarKardex(@PathVariable("idKardex")Long idKardex,
			@RequestBody Kardex kardex){
		
		kardex.setIdkardex(idKardex);
		
		Kardex kardexDB = kardexServicio.editarKardex(kardex);
		
		if (kardexDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(kardexDB);
	}
	
	@DeleteMapping(value = "eliminarKardex/{idKardex}")
	public void eliminarKardex(@PathVariable("idKardex")Long idkardex){
		
		kardexServicio.eliminarKardex(idkardex);
	}	
}
