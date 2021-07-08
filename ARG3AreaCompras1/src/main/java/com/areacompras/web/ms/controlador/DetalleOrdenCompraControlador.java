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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.areacompras.web.ms.modelo.DetalleOrdenCompra;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Productos;
import com.areacompras.web.ms.servicio.DetalleOrdenCompraServicio;

@RestController
@RequestMapping(value = "/detalleOrdenCompra")
public class DetalleOrdenCompraControlador {
	
	@Autowired
	private DetalleOrdenCompraServicio detalleOrdenCompraServicio;
		
	@RequestMapping(value = "/listarDetalleOrdenCompra", method = RequestMethod.GET)
	public ResponseEntity<List<DetalleOrdenCompra>> listarDetalleOrdenCompra(@RequestParam(name = "OrdenCompraId",
	required = false) Integer OrdenCompraId,@RequestParam(name = "ProductoId",required = false)Integer ProductoId) {
		
		List<DetalleOrdenCompra> detalleOrdenCompra = new ArrayList<>();
		
		if(null == OrdenCompraId && null == ProductoId) {
			detalleOrdenCompra = detalleOrdenCompraServicio.BuscarTodosDetalleOrdenCompra();
			if(detalleOrdenCompra.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			detalleOrdenCompra = detalleOrdenCompraServicio.findByOrdenCompra(OrdenCompra.builder()
					.idOrdenCompra(OrdenCompraId).build());
			detalleOrdenCompra = detalleOrdenCompraServicio.findByProductos(Productos.builder()
					.idProducto(ProductoId).build());
			if(detalleOrdenCompra.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(detalleOrdenCompra);
	}
	
	@GetMapping(value = "buscarDetalleOrdenCompra/{idDetalleOrdenCompra}")
	public ResponseEntity<DetalleOrdenCompra> getProduct(@PathVariable("idDetalleOrdenCompra")Integer idDetalleOrdenCompra){
		DetalleOrdenCompra detalleOrdenCompra=detalleOrdenCompraServicio.BuscarPorIdDetalleOrdenCompra(idDetalleOrdenCompra);
		if (null==detalleOrdenCompra) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleOrdenCompra);
	}
	
	@PostMapping
	public ResponseEntity<DetalleOrdenCompra> crearDetalleOrdenCompra(@Validated @RequestBody DetalleOrdenCompra detalleOrdenCompra,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		DetalleOrdenCompra detalleOrdenCompraCrear=detalleOrdenCompraServicio.crearDetalleOrdenCompra(detalleOrdenCompra);
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleOrdenCompraCrear);
	}
	
	@PutMapping(value = "editarDetalleOrdenCompra/{idDetalleOrdenCompra}")
	public ResponseEntity<DetalleOrdenCompra> editarDetalleOrdenCompra(@PathVariable("idDetalleOrdenCompra")Integer idDetalleOrdenCompra,
			@RequestBody DetalleOrdenCompra detalleOrdenCompra){
		detalleOrdenCompra.setIdDetalleOrdenCompra(idDetalleOrdenCompra);
		DetalleOrdenCompra detalleOrdenCompraDB=detalleOrdenCompraServicio.editarDetalleOrdenCompra(detalleOrdenCompra);
		if (detalleOrdenCompraDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(detalleOrdenCompraDB);
	}
	
	@DeleteMapping(value = "eliminarDetalleOrdenCompra/{idDetalleOrdenCompra}")
	public void eliminarDetalleOrdenCompra(@PathVariable("idDetalleOrdenCompra")Integer idDetalleOrdenCompra){
		detalleOrdenCompraServicio.eliminarDetalleOrdenCompra(idDetalleOrdenCompra);
	}
}
