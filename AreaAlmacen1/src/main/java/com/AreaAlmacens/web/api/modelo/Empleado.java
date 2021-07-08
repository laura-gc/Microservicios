package com.AreaAlmacens.web.api.modelo;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	
	private String Nombres;
	private String DocIdentidad;
	private String Telefono;
	private String Correo;
	private String Direccion;
	 
	@Column(name = "FechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date FechaRegistro;
}
