package com.areacobranza.web.ms.servicio;

import java.util.List;

import com.areacobranza.web.ms.modelo.Deuda;
import com.areacobranza.web.ms.modelo.DocVenta;

public interface DeudaServicio {
	public List<Deuda>BuscarTodosDeuda();
	public Deuda BuscarPorIdDeuda(int idDeuda);
	
	public Deuda crearDeuda(Deuda deuda);
	public Deuda editarDeuda(Deuda deuda);
	public void eliminarDeuda(int idDeuda);
	
	public List<Deuda> findByDocVenta(DocVenta docVenta);
}
