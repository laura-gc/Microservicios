package com.AreaAlmacens.web.api.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AreaAlmacens.web.api.modelo.Cliente;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Empleado;
import com.AreaAlmacens.web.api.repositorio.DocVentasRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocVentaServicioImplementa implements DocVentaServicio{
	
	private final DocVentasRepositorio docventaRepositorio;
	
	
	@Override
	public List<DocVenta> ListarTodo() {
		
		return docventaRepositorio.findAll();
	}

	@Override
	public DocVenta BuscarPorIdDocVenta(Long idDocVenta) {
		
		return docventaRepositorio.findById(idDocVenta).orElse(null);
	}

	@Override
	public DocVenta crearDocVenta(DocVenta docVenta) {
        
		docVenta.setFecha(new Date());
		
		return docventaRepositorio.save(docVenta);
	}

	@Override
	public DocVenta editarDocVenta(DocVenta docVenta) {
		
		DocVenta docVentaDB = BuscarPorIdDocVenta(docVenta.getIdDocVenta());
		
		if (null == docVentaDB) {
			return null;
		}
		
		docVentaDB.setCliente(docVenta.getCliente());
		docVentaDB.setEmpleado(docVenta.getEmpleado());

		
		return docventaRepositorio.save(docVentaDB); 
	}

	@Override
	public void eliminarDocVenta(Long idDocVenta) {
		
		docventaRepositorio.deleteById(idDocVenta);
		
	}

	@Override
	public List<DocVenta> findByEmpleado(Empleado empleados) {
		
		return docventaRepositorio.findByEmpleado(empleados);
	}

	@Override
	public List<DocVenta> findByCliente(Cliente cliente) {
		
		return docventaRepositorio.findByCliente(cliente); 
	}

}
