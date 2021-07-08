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

import com.areacompras.web.ms.modelo.Productos;
import com.areacompras.web.ms.servicio.ProductosServicio;

@RestController
@RequestMapping(value = "productos")
public class ProductosControlador {
	
	@Autowired
	private ProductosServicio productosServicio;
	
	@RequestMapping(value = "/listarProductos",method = RequestMethod.GET)
	public ResponseEntity<List<Productos>>listarProductos(){
		List<Productos> productos=new ArrayList<>();
		
		productos=productosServicio.BuscarTodosProductos();
		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping(value = "buscarProducto/{idProducto}")
	public ResponseEntity<Productos> buscarProducto(@PathVariable("idProducto")Integer idProducto){
		Productos productos=productosServicio.BuscarPorIdProducto(idProducto);
		if (null==productos) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productos);
	}
	
	@PostMapping
	public ResponseEntity<Productos> crearProducto(@Validated @RequestBody Productos productos,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Productos productoCrear=productosServicio.crearProducto(productos);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoCrear);
	}
	
	@PutMapping(value = "editarProducto/{idProducto}")
	public ResponseEntity<Productos> editarProducto(@PathVariable("idProducto")Integer idProducto,
			@RequestBody Productos productos){
		productos.setIdProducto(idProducto);
		Productos productoDB=productosServicio.editarProducto(productos);
		if (productoDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productoDB);
	}
	
	@DeleteMapping(value = "eliminarProducto/{idProducto}")
	public void eliminarProducto(@PathVariable("idProducto")Integer idProducto){
		productosServicio.eliminarProducto(idProducto);
	}
}
