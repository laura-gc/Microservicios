package com.areacobranza.web.ms.controlador;

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

import com.areacobranza.web.ms.modelo.Deuda;
import com.areacobranza.web.ms.modelo.DocVenta;
import com.areacobranza.web.ms.servicio.DeudaServicio;

@RestController
@RequestMapping(value = "/deuda")
public class DeudaControlador {

	@Autowired
	private DeudaServicio deudaServicio;
		
	@RequestMapping(value = "/listarDeuda", method = RequestMethod.GET)
	public ResponseEntity<List<Deuda>> listarDeuda(@RequestParam(name = "DocVentaId",
	required = false) Integer DocVentaId) {
		
		List<Deuda> deuda = new ArrayList<>();
		
		if(null == DocVentaId) {
			deuda = deudaServicio.BuscarTodosDeuda();
			if(deuda.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			deuda = deudaServicio.findByDocVenta(DocVenta.builder()
					.idDocVenta(DocVentaId).build());
			if(deuda.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(deuda);
	}
	
	@GetMapping(value = "buscarDeuda/{idDeuda}")
	public ResponseEntity<Deuda> buscarDeuda(@PathVariable("idDeuda")Integer idDeuda){
		Deuda deuda=deudaServicio.BuscarPorIdDeuda(idDeuda);
		if (null==deuda) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(deuda);
	}
	
	@PostMapping
	public ResponseEntity<Deuda> crearDeuda(@Validated @RequestBody Deuda deuda,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Deuda deudaCrear=deudaServicio.crearDeuda(deuda);
		return ResponseEntity.status(HttpStatus.CREATED).body(deudaCrear);
	}
	
	@PutMapping(value = "editarDeuda/{idDeuda}")
	public ResponseEntity<Deuda> editarDeuda(@PathVariable("idDeuda")Integer idDeuda,
			@RequestBody Deuda deuda){
		deuda.setIdDeuda(idDeuda);
		Deuda deudaDB=deudaServicio.editarDeuda(deuda);
		if (deudaDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(deudaDB);
	}
	
	@DeleteMapping(value = "eliminarDeuda/{idDeuda}")
	public void eliminarDeuda(@PathVariable("idDeuda")Integer idDeuda){
		deudaServicio.eliminarDeuda(idDeuda);
	}
}
