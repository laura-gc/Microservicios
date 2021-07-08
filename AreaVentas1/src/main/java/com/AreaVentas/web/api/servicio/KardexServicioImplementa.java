package com.AreaVentas.web.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaVentas.web.api.modelo.Almacen;
import com.AreaVentas.web.api.modelo.Kardex;
import com.AreaVentas.web.api.repositorio.KardexRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KardexServicioImplementa implements KardexServicio{

	private final KardexRepositorio kardexRepositorio;
 
	@Override
	public List<Kardex> BuscarTodos() {
		
		return kardexRepositorio.findAll();
	}

	@Override
	public Kardex BuscarPorIdKardex(Long idKardex) {
		
		return kardexRepositorio.findById(idKardex).orElse(null);
	}

	@Override
	public Kardex crearKardex(Kardex kardex) {
		
		return kardexRepositorio.save(kardex);
	}

	@Override
	public Kardex editarKardex(Kardex kardex) {
		
		Kardex kardexDB=BuscarPorIdKardex(kardex.getIdkardex());
		
		if (null == kardexDB) {
			return null;
		}
		
		kardexDB.setTipomov(kardex.getTipomov());
		kardexDB.setIddocumento(kardex.getIddocumento());
		kardexDB.setAlmacen(kardex.getAlmacen());
		
		return kardexRepositorio.save(kardexDB);
	}

	@Override
	public void eliminarKardex(Long idKardex) {
		 
		kardexRepositorio.deleteById(idKardex);
		
	}

	@Override
	public List<Kardex> findByAlmacen(Almacen almacen) {
		
		return kardexRepositorio.findByAlmacen(almacen); 
	}	
}
