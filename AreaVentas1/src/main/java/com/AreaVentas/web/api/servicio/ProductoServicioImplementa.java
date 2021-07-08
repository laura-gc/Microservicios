package com.AreaVentas.web.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaVentas.web.api.modelo.Producto;
import com.AreaVentas.web.api.repositorio.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServicioImplementa implements ProductoServicio {

	private ProductoRepositorio productoRepositorio;

	@Override
	public List<Producto> BuscarTodos() {
		
		return productoRepositorio.findAll();
	}

	@Override
	public Producto BuscarPorIdProducto(Long idProducto) {
		
		return productoRepositorio.findById(idProducto).orElse(null);
	}

	@Override
	public Producto crearProducto(Producto productos) {
		
		return productoRepositorio.save(productos);
	}

	@Override
	public Producto editarProducto(Producto productos) {
		
		Producto productosDB=BuscarPorIdProducto(productos.getIdproducto());
		
		if (null == productosDB) {
			return null;
		}
		productosDB.setNombre(productos.getNombre());
		productosDB.setPrecio(productos.getPrecio());
		productosDB.setStock(productos.getStock());
		
		return productoRepositorio.save(productosDB);
	}

	@Override
	public void eliminarProducto(Long idProducto) {
		
		productoRepositorio.deleteById(idProducto);
		
	}
}
