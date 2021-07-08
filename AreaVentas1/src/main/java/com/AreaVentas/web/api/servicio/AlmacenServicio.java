package com.AreaVentas.web.api.servicio;

import java.util.List;

import com.AreaVentas.web.api.modelo.Almacen;

public interface AlmacenServicio {

	public List<Almacen> listarTodos();   
	public Almacen BuscarPorIdAlmacen(Long idalmacen);
	  
	public Almacen crearAlmacen(Almacen almacen);
	public Almacen editarAlmacen(Almacen almacen);
	public void eliminarAlmacen(Long idalmacen);
	
}
