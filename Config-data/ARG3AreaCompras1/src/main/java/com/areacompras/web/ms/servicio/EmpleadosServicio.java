package com.areacompras.web.ms.servicio;

import java.util.List;

import com.areacompras.web.ms.modelo.Empleados;

public interface EmpleadosServicio {
	public List<Empleados>BuscarTodosEmpleados();
	public Empleados BuscarPorIdEmpleado(int idEmpleado);
	
	public Empleados crearEmpleado(Empleados empleados);
	public Empleados editarEmpleado(Empleados empleados);
	public void eliminarEmpleado(int idEmpleado);
}
