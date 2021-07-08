package com.areacompras.web.ms.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.areacompras.web.ms.modelo.DetalleOrdenCompra;
import com.areacompras.web.ms.modelo.OrdenCompra;
import com.areacompras.web.ms.modelo.Productos;
import com.areacompras.web.ms.repositorio.DetalleOrdenCompraRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleOrdenCompraServicioImplementa implements DetalleOrdenCompraServicio{

	private final DetalleOrdenCompraRepositorio detalleOrdenCompraRepositorio;
	
	@Override
	public List<DetalleOrdenCompra> BuscarTodosDetalleOrdenCompra() {
		return detalleOrdenCompraRepositorio.findAll();
	}

	@Override
	public DetalleOrdenCompra BuscarPorIdDetalleOrdenCompra(int idDetalleOrdenCompra) {
		return detalleOrdenCompraRepositorio.findById(idDetalleOrdenCompra).orElse(null);
	}

	@Override
	public DetalleOrdenCompra crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
		return detalleOrdenCompraRepositorio.save(detalleOrdenCompra);
	}

	@Override
	public DetalleOrdenCompra editarDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
		DetalleOrdenCompra detalleOrdenCompraDB=BuscarPorIdDetalleOrdenCompra(detalleOrdenCompra.getIdDetalleOrdenCompra());
		if (null == detalleOrdenCompraDB) {
			return null;
		}
		detalleOrdenCompraDB.setCantidad(detalleOrdenCompra.getCantidad());
		detalleOrdenCompraDB.setPrecio(detalleOrdenCompra.getPrecio());
		detalleOrdenCompraDB.setOrdenCompra(detalleOrdenCompra.getOrdenCompra());
		detalleOrdenCompraDB.setProductos(detalleOrdenCompra.getProductos());
		return detalleOrdenCompraRepositorio.save(detalleOrdenCompraDB);
	}

	@Override
	public void eliminarDetalleOrdenCompra(int idDetalleOrdenCompra) {
		detalleOrdenCompraRepositorio.deleteById(idDetalleOrdenCompra);
	}

	@Override
	public List<DetalleOrdenCompra> findByOrdenCompra(OrdenCompra ordenCompra) {
		return detalleOrdenCompraRepositorio.findByOrdenCompra(ordenCompra);
	}

	@Override
	public List<DetalleOrdenCompra> findByProductos(Productos productos) {
		return detalleOrdenCompraRepositorio.findByProductos(productos);
	}

}
