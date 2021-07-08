package com.AreaVentas.web.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaVentas.web.api.modelo.Almacen;
import com.AreaVentas.web.api.modelo.Kardex;

@Repository
public interface KardexRepositorio extends JpaRepository<Kardex, Long>{
	
	public List<Kardex> findByAlmacen(Almacen Almacen);
}
