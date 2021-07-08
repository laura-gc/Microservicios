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

import com.AreaVentas.web.api.modelo.DetalleKardex;
import com.AreaVentas.web.api.modelo.Kardex;
import com.AreaVentas.web.api.modelo.Producto;
import com.AreaVentas.web.api.servicio.DetalleKardexServicio;

@RestController
@RequestMapping(value = "/DetalleKardex") 
public class DetalleKardexController {

	@Autowired
	private DetalleKardexServicio detalleServicio;
	
	@RequestMapping(value = "/listarDetalleKardex", method = RequestMethod.GET)
	public ResponseEntity<List<DetalleKardex>> listarDetalleKardex(@RequestParam(name = "KardexId",
	required = false) Long KardexId,@RequestParam(name = "ProductoId",required = false) Long ProductoId) {
		
		List<DetalleKardex> detalleKardex = new ArrayList<>();
		
		if(null == KardexId && null == ProductoId) {
			
			detalleKardex = detalleServicio.ListarTodos();
			
			if(detalleKardex.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			detalleKardex = detalleServicio.findByKardex(Kardex.builder().idkardex(KardexId).build());
			detalleKardex = detalleServicio.findByProducto(Producto.builder().idproducto(ProductoId).build());
			
			if(detalleKardex.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(detalleKardex);
	}
	
	@GetMapping(value = "buscarDetalleKardex/{idDetalleKardex}")
	public ResponseEntity<DetalleKardex> getDetalleKardex(@PathVariable("idDetalleKardex")Long idDetalleKardex){
		
		DetalleKardex detalleKardex = detalleServicio.BuscarPorIdDetalleKardex(idDetalleKardex);
		
		if (null==detalleKardex) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleKardex); 
	}
	
	@PostMapping
	public ResponseEntity<DetalleKardex> crearDetalleKardex(@Validated @RequestBody DetalleKardex detalleKardex,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		DetalleKardex detalleKardexCrear = detalleServicio.crearDetalleKardex(detalleKardex);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleKardexCrear);
	}
	
	@PutMapping(value = "editarDetalleKardex/{idDetalleKardex}")
	public ResponseEntity<DetalleKardex> editarDetalleOrdenCompra(@PathVariable("idDetalleKardex")Long idDetalleKardex,
			@RequestBody DetalleKardex DetalleKardex){
		
		DetalleKardex.setIddetallekardex(idDetalleKardex);
		
		DetalleKardex detalleKardexDB =detalleServicio.editarDetalleKardexCompra(DetalleKardex);
		
		if (detalleKardexDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleKardexDB);
	}
	
	@DeleteMapping(value = "eliminarDetalleKardex/{idDetalleKardex}")
	public void eliminarDetalleOrdenCompra(@PathVariable("idDetalleKardex")Long idDetalleKardex){
		
		detalleServicio.eliminarDetalleKardex(idDetalleKardex);
	}
}
