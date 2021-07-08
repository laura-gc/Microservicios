package com.AreaAlmacens.web.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaAlmacens.web.api.modelo.DocDetalleVenta;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Producto;
import com.AreaAlmacens.web.api.repositorio.DocDetalleVentasRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocDetalleVentaServicioImplementa implements DocDetalleVentaServicio{
	 
	private final DocDetalleVentasRepositorio docDetalleVentaRepositorio;

	@Override
	public List<DocDetalleVenta> listarTodo() {
		
		return docDetalleVentaRepositorio.findAll();
	}
 
	@Override
	public DocDetalleVenta BuscarPorIdDocDetalleVenta(Long idDocDetalleVenta) {
		
		return docDetalleVentaRepositorio.findById(idDocDetalleVenta).orElse(null);
	}

	@Override
	public DocDetalleVenta crearDocDetalleVenta(DocDetalleVenta docDetalleVenta) {
		
		docDetalleVenta.setDescuento((float) (docDetalleVenta.getPrecio() * 0.15)); 
		docDetalleVenta.setTotal((docDetalleVenta.getPrecio() - docDetalleVenta.getDescuento()) * docDetalleVenta.getCantidad());
		
		
		return docDetalleVentaRepositorio.save(docDetalleVenta);
	}

	@Override
	public DocDetalleVenta editarDocDetalleVenta(DocDetalleVenta docDetalleVenta) {
		
		DocDetalleVenta docDetalleVentaDB = BuscarPorIdDocDetalleVenta(docDetalleVenta.getDocDetalleVenta());
		
		if (null == docDetalleVentaDB) {
			return null;
		}
		
		docDetalleVentaDB.setCantidad(docDetalleVenta.getCantidad());
		docDetalleVentaDB.setPrecio(docDetalleVenta.getPrecio());
		docDetalleVentaDB.setDescuento((float) (docDetalleVenta.getPrecio() * 0.15)); 
		docDetalleVentaDB.setTotal((docDetalleVenta.getPrecio() - docDetalleVenta.getDescuento()) * docDetalleVenta.getCantidad());
		docDetalleVentaDB.setProducto(docDetalleVenta.getProducto());
		docDetalleVentaDB.setDocVenta(docDetalleVenta.getDocVenta()); 
		
		return docDetalleVentaRepositorio.save(docDetalleVentaDB);
	}

	@Override
	public void eliminarDocDetalleVenta(Long idDocDetalleVenta) {
		
		docDetalleVentaRepositorio.deleteById(idDocDetalleVenta);
		
	}

	@Override
	public List<DocDetalleVenta> findByProducto(Producto producto) {
		
		return docDetalleVentaRepositorio.findByProducto(producto);
	}

	@Override
	public List<DocDetalleVenta> findByDocVenta(DocVenta docVenta) {
		
		return docDetalleVentaRepositorio.findByDocVenta(docVenta); 
	}
	
	
}
