package com.AreaVentas.web.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaVentas.web.api.modelo.Almacen;
import com.AreaVentas.web.api.repositorio.AlmacenRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlmacenServicioImplementa  implements AlmacenServicio{

	private final AlmacenRepositorio  almacenRepositorio;
	 
	@Override
	public List<Almacen> listarTodos() {
		
		return almacenRepositorio.findAll();
	}

	@Override
	public Almacen BuscarPorIdAlmacen(Long idalmacen) {
		
		return almacenRepositorio.findById(idalmacen).orElse(null);
	}

	@Override
	public Almacen crearAlmacen(Almacen almacen) {
		
		return almacenRepositorio.save(almacen); 
	}

	@Override
	public Almacen editarAlmacen(Almacen almacen) {
		
		Almacen almcenDB=BuscarPorIdAlmacen(almacen.getIdalmacen());
		
		if (null == almcenDB) {
			return null;
		}
		almcenDB.setNombre(almacen.getNombre());
		almcenDB.setCapacidad(almacen.getCapacidad());
		
		return almacenRepositorio.save(almcenDB);
	}

	@Override
	public void eliminarAlmacen(Long idalmacen) {
		
		almacenRepositorio.deleteById(idalmacen); 
		
	} 

}
