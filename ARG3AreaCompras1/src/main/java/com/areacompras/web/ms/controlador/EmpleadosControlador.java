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

import com.areacompras.web.ms.modelo.Empleados;
import com.areacompras.web.ms.servicio.EmpleadosServicio;


@RestController
@RequestMapping(value = "empleados")
public class EmpleadosControlador {
	
	@Autowired
	private EmpleadosServicio empleadosServicio;
	
	@RequestMapping(value = "/listarEmpleados",method = RequestMethod.GET)
	public ResponseEntity<List<Empleados>>listarEmpleados(){
		List<Empleados> empleados=new ArrayList<>();
		
		empleados=empleadosServicio.BuscarTodosEmpleados();
		if (empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(empleados);
	}
	
	@GetMapping(value = "buscarEmpleado/{idEmpleado}")
	public ResponseEntity<Empleados> buscarEmpleado(@PathVariable("idEmpleado")Integer idEmpleado){
		Empleados empleados=empleadosServicio.BuscarPorIdEmpleado(idEmpleado);
		if (null==empleados) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empleados);
	}
	
	@PostMapping
	public ResponseEntity<Empleados> crearEmpleado(@Validated @RequestBody Empleados empleados,
			BindingResult result){
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Empleados empleadoCrear=empleadosServicio.crearEmpleado(empleados);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCrear);
	}
	
	@PutMapping(value = "editarEmpleado/{idEmpleado}")
	public ResponseEntity<Empleados> editarEmpleado(@PathVariable("idEmpleado")Integer idEmpleado,
			@RequestBody Empleados empleados){
		empleados.setIdEmpleado(idEmpleado);
		Empleados empleadoDB=empleadosServicio.editarEmpleado(empleados);
		if (empleadoDB == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empleadoDB);
	}
	
	@DeleteMapping(value = "eliminarEmpleado/{idEmpleado}")
	public void eliminarEmpleado(@PathVariable("idEmpleado")Integer idEmpleado){
		empleadosServicio.eliminarEmpleado(idEmpleado);
	}
}
