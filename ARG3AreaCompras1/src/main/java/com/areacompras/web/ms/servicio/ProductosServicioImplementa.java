package com.areacompras.web.ms.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.areacompras.web.ms.modelo.Productos;
import com.areacompras.web.ms.repositorio.ProductosRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductosServicioImplementa implements ProductosServicio{

	
	private final ProductosRepositorio productosRepositorio;
	
	@Override
	public List<Productos> BuscarTodosProductos() {
		return productosRepositorio.findAll();
	}

	@Override
	public Productos BuscarPorIdProducto(int idProducto) {
		return productosRepositorio.findById(idProducto).orElse(null);
	}

	@Override
	public Productos crearProducto(Productos productos) {
		return productosRepositorio.save(productos);
	}

	@Override
	public Productos editarProducto(Productos productos) {
		Productos productosDB=BuscarPorIdProducto(productos.getIdProducto());
		if (null == productosDB) {
			return null;
		}
		productosDB.setNombre(productos.getNombre());
		productosDB.setPrecio(productos.getPrecio());
		productosDB.setStock(productos.getStock());
		return productosRepositorio.save(productosDB);
	}

	@Override
	public void eliminarProducto(int idProducto) {
		productosRepositorio.deleteById(idProducto);
	}

}
