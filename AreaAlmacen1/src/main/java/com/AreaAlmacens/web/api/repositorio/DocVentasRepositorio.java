package com.AreaAlmacens.web.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaAlmacens.web.api.modelo.Cliente;
import com.AreaAlmacens.web.api.modelo.DocVenta;
import com.AreaAlmacens.web.api.modelo.Empleado;

@Repository
public interface DocVentasRepositorio extends JpaRepository<DocVenta, Long> {

	public List<DocVenta> findByCliente(Cliente cliente);
	
	public List<DocVenta> findByEmpleado(Empleado empleado);
	
}
