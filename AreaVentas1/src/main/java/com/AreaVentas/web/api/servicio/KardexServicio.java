package com.AreaVentas.web.api.servicio;

import java.util.List;

import com.AreaVentas.web.api.modelo.Almacen;
import com.AreaVentas.web.api.modelo.Kardex;

public interface KardexServicio {
	     
	
	public List<Kardex>BuscarTodos();
	public Kardex BuscarPorIdKardex(Long idKardex);
	 
	public Kardex crearKardex(Kardex kardex);
	public Kardex editarKardex(Kardex kardex);
	public void eliminarKardex(Long idKardex);
	  
	public List<Kardex> findByAlmacen(Almacen almacen);

}
