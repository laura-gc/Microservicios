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

import com.AreaAlmacens.web.api.modelo.DocDetalleVenta;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Producto;
import com.AreaAlmacens.web.api.servicio.DocDetalleVentaServicio;

@RestController
@RequestMapping(value = "docDetalleVenta")
public class DocDetalleVentaController {

	@Autowired
	private DocDetalleVentaServicio docDetalleVentaServicio;
		
	@RequestMapping(value = "/listarDocDetalleVenta", method = RequestMethod.GET)
	public ResponseEntity<List<DocDetalleVenta>> listarDocDetalleVenta(@RequestParam(name = "productoId",
	required = false) Long productoId,@RequestParam(name = "docVentaId",required = false)Long docVentaId) {
		
		List<DocDetalleVenta> docDetalleVenta = new ArrayList<>();
		
		if(null == productoId && null == docVentaId) {
			
			docDetalleVenta = docDetalleVentaServicio.listarTodo();
			
			if(docDetalleVenta.isEmpty()) {
				
				return ResponseEntity.noContent().build();
			}
		}else {
			docDetalleVenta = docDetalleVentaServicio.findByProducto(Producto.builder().idProducto(productoId).build());
			docDetalleVenta = docDetalleVentaServicio.findByDocVenta(DocVenta.builder().idDocVenta(docVentaId).build());
			
			if(docDetalleVenta.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(docDetalleVenta);
	}
	
	@GetMapping(value = "buscarDocDetalleVenta/{idDocDetalleVenta}")
	public ResponseEntity<DocDetalleVenta> getDocDetalleVenta(@PathVariable("idDocDetalleVenta")Long idDocDetalleVenta){
		
		DocDetalleVenta docDetalleVenta = docDetalleVentaServicio.BuscarPorIdDocDetalleVenta(idDocDetalleVenta);
		
		if (null==docDetalleVenta) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(docDetalleVenta);
	}
	
	@PostMapping
	public ResponseEntity<DocDetalleVenta> crearDocDetalleVenta(@Validated @RequestBody DocDetalleVenta docDetalleVenta,
			BindingResult result){
		
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);//this.formatMessage(
		}
		
		DocDetalleVenta docDetalleVentaCrear= docDetalleVentaServicio.crearDocDetalleVenta(docDetalleVenta);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(docDetalleVentaCrear);
	}
	
	@PutMapping(value = "editarDocDetalleVenta/{idDocDetalleVenta}")
	public ResponseEntity<DocDetalleVenta> editarDocDetalleVenta(@PathVariable("idDocDetalleVenta")Long idDocDetalleVenta,
			@RequestBody DocDetalleVenta docDetalleVenta){
		
		docDetalleVenta.setDocDetalleVenta(idDocDetalleVenta);
		 
		DocDetalleVenta docDetalleVentaDB = docDetalleVentaServicio.editarDocDetalleVenta(docDetalleVenta);
		
		if (docDetalleVentaDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(docDetalleVentaDB);
	}
	
	@DeleteMapping(value = "eliminarDocDetalleVenta/{idDocDetalleVenta}")
	public void eliminarProveedor(@PathVariable("idDocDetalleVenta")Long idDocDetalleVenta){
		
		docDetalleVentaServicio.eliminarDocDetalleVenta(idDocDetalleVenta);
	}
}
