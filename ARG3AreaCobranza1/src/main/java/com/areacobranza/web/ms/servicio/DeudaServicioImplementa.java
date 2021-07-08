package com.areacobranza.web.ms.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.areacobranza.web.ms.modelo.Deuda;
import com.areacobranza.web.ms.modelo.DocVenta;
import com.areacobranza.web.ms.repositorio.DeudaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeudaServicioImplementa implements DeudaServicio{

	private final DeudaRepositorio deudaRepositorio;
	
	@Override
	public List<Deuda> BuscarTodosDeuda() {
		return deudaRepositorio.findAll();
	}

	@Override
	public Deuda BuscarPorIdDeuda(int idDeuda) {
		return deudaRepositorio.findById(idDeuda).orElse(null);
	}

	@Override
	public Deuda crearDeuda(Deuda deuda) {
		deuda.setFechaPago(new Date());
		
		return deudaRepositorio.save(deuda);
	}

	@Override
	public Deuda editarDeuda(Deuda deuda) {
		Deuda deudaDB=BuscarPorIdDeuda(deuda.getIdDeuda());
		if (null == deudaDB) {
			return null;
		}
		deudaDB.setDocVenta(deuda.getDocVenta());
		deudaDB.setMonto(deuda.getMonto());
		deudaDB.setEstado(deuda.getEstado());
		//deudaDB.setFechaPago(deuda.getFechaPago());
		return deudaRepositorio.save(deudaDB);
	}

	@Override
	public void eliminarDeuda(int idDeuda) {
		deudaRepositorio.deleteById(idDeuda);
	}

	@Override
	public List<Deuda> findByDocVenta(DocVenta docVenta) {
		return deudaRepositorio.findByDocVenta(docVenta);
	}

}
