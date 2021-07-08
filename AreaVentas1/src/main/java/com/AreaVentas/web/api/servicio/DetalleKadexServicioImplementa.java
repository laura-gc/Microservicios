package com.AreaVentas.web.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaVentas.web.api.modelo.DetalleKardex;
import com.AreaVentas.web.api.modelo.Kardex;
import com.AreaVentas.web.api.modelo.Producto;
import com.AreaVentas.web.api.repositorio.DetalleKardexRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleKadexServicioImplementa implements DetalleKardexServicio{
	
	private final DetalleKardexRepositorio detalleKardexRepositorio;

	@Override
	public List<DetalleKardex> ListarTodos() {
		
		return detalleKardexRepositorio.findAll();
	}

	@Override
	public DetalleKardex BuscarPorIdDetalleKardex(Long iddetallekardex) {
		
		return detalleKardexRepositorio.findById(iddetallekardex).orElse(null);
	}

	@Override
	public DetalleKardex crearDetalleKardex(DetalleKardex detalleKardex) {
		
		return detalleKardexRepositorio.save(detalleKardex);
	}

	@Override
	public DetalleKardex editarDetalleKardexCompra(DetalleKardex detalleKardex) {
		
		DetalleKardex detalleKardexDB= BuscarPorIdDetalleKardex(detalleKardex.getIddetallekardex());
		if (null == detalleKardexDB) {
			return null;
		}
		detalleKardexDB.setCantidad(detalleKardex.getCantidad());
		detalleKardexDB.setKardex(detalleKardex.getKardex());
		detalleKardexDB.setProducto(detalleKardex.getProducto());
		
		return detalleKardexRepositorio.save(detalleKardexDB);
	}

	@Override
	public void eliminarDetalleKardex(Long iddetallekardex) {
		
		detalleKardexRepositorio.deleteById(iddetallekardex);
		
	}

	@Override
	public List<DetalleKardex> findByKardex(Kardex Kardex) {
		
		return detalleKardexRepositorio.findByKardex(Kardex);
	}

	@Override
	public List<DetalleKardex> findByProducto(Producto producto) {
		
		return detalleKardexRepositorio.findByProducto(producto);
	}
}
