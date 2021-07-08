package com.AreaAlmacens.web.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AreaAlmacens.web.api.modelo.Cliente;
 
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
