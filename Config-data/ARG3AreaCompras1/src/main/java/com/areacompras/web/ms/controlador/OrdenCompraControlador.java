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

import com.areacompras.web.ms.modelo.Empleados;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Proveedores;
import com.areacompras.web.ms.servicio.OrdenCompraServicio;

@RestController
@RequestMapping(value = "/ordenCompra")
public class OrdenCompraControlador {

	@Autowired
	private OrdenCompraServicio ordenCompraServicio;
		
	@RequestMapping(value = "/listarOrdenCompra", method = RequestMethod.GET)
	public ResponseEntity<List<OrdenCompra>> listarOrdenCompra(@RequestParam(name = "EmpleadoId",
	required = false) Integer EmpleadoId,@RequestParam(name = "ProveedorId",required = false)Integer ProveedorId) {
		
		List<OrdenCompra> ordenCompra = new ArrayList<>();
		
		if(null == EmpleadoId && null == ProveedorId) {
			ordenCompra = ordenCompraServicio.BuscarTodosOrdenCompra();
			if(ordenCompra.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			ordenCompra = ordenCompraServicio.findByEmpleados(Empleados.builder()
					.idEmpleado(EmpleadoId).build());
			ordenCompra = ordenCompraServicio.findByProveedores(Proveedores.builder()
					.idProveedor(ProveedorId).build());
			if(ordenCompra.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}		
		return ResponseEntity.ok(ordenCompra);
	}
	
	@GetMapping(value = "buscarOrdenCompra/{idOrdenCompra}")
	public ResponseEntity<OrdenCompra> getProduct(@PathVariable("idOrdenCompra")Integer idOrdenCompra){
		OrdenCompra ordenCompra=ordenCompraServicio.BuscarPorIdOrdenCompra(idOrdenCompra);
		if (null==ordenCompra) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ordenCompra);
	}
	
	@PostMapping
	public ResponseEntity<OrdenCompra> crearOrdenCompra(@Validated @RequestBody OrdenCompra ordenCompra,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);//this.formatMessage(
		}
		OrdenCompra ordenCompraCrear=ordenCompraServicio.crearOrdenCompra(ordenCompra);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordenCompraCrear);
	}
	
	@PutMapping(value = "editarOrdenCompra/{idOrdenCompra}")
	public ResponseEntity<OrdenCompra> editarOrdenCompra(@PathVariable("idOrdenCompra")Integer idOrdenCompra,
			@RequestBody OrdenCompra ordenCompra){
		ordenCompra.setIdOrdenCompra(idOrdenCompra);
		OrdenCompra ordenCompraDB=ordenCompraServicio.editarOrdenCompra(ordenCompra);
		if (ordenCompraDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ordenCompraDB);
	}
	
	@DeleteMapping(value = "eliminarOrdenCompra/{idOrdenCompra}")
	public void eliminarProveedor(@PathVariable("idOrdenCompra")Integer idOrdenCompra){
		ordenCompraServicio.eliminarOrdenCompra(idOrdenCompra);
	}
}
