package com.AreaAlmacens.web.api.modelo;

import java.util.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cliente {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente; 
	
	private String nombre;
	private String DocIdentidad;
	private String telefono;
	private String correo;
	private String direccion;
	
	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro; 
}
