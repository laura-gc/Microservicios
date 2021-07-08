package com.areacompras.web.ms.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.areacompras.web.ms.modelo.Empleados;
import com.areacompras.web.ms.repositorio.EmpleadosRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadosServicioImplementa implements EmpleadosServicio{

	
	private final EmpleadosRepositorio empleadosRepositorio;
	
	@Override
	public List<Empleados> BuscarTodosEmpleados() {
		return empleadosRepositorio.findAll();
	}

	@Override
	public Empleados BuscarPorIdEmpleado(int idEmpleado) {
		return empleadosRepositorio.findById(idEmpleado).orElse(null);
	}

	@Override
	public Empleados crearEmpleado(Empleados empleados) {
		empleados.setFechaRegistro(new Date());
		return empleadosRepositorio.save(empleados);
	}

	@Override
	public Empleados editarEmpleado(Empleados empleados) {
		Empleados empleadosDB=BuscarPorIdEmpleado(empleados.getIdEmpleado());
		if (null == empleadosDB) {
			return null;
		}
		empleadosDB.setNombres(empleados.getNombres());
		empleadosDB.setDocIdentidad(empleados.getDocIdentidad());
		empleadosDB.setTelefono(empleados.getTelefono());
		empleadosDB.setCorreo(empleados.getCorreo());
		empleadosDB.setDireccion(empleados.getDireccion());
		//empleadosDB.setFechaRegistro(empleados.getFechaRegistro());
		return empleadosRepositorio.save(empleadosDB);
	}

	@Override
	public void eliminarEmpleado(int idEmpleado) {
		empleadosRepositorio.deleteById(idEmpleado);
	}

}
