package com.areacobranza.web.ms.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.areacobranza.web.ms.modelo.Deuda;
import com.areacobranza.web.ms.modelo.DocVenta;

public interface DeudaRepositorio extends JpaRepository<Deuda, Integer>{
	//Metodo que permite buscar por DocVenta
	//Dentro de la tabla Deuda
	public List<Deuda> findByDocVenta(DocVenta docVenta);
}
