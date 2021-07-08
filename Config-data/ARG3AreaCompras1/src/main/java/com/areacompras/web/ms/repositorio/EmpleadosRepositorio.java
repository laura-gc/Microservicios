package com.areacompras.web.ms.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.areacompras.web.ms.modelo.Empleados;

public interface EmpleadosRepositorio extends JpaRepository<Empleados, Integer> {

}
