package com.AreaAlmacens.web.api.modelo;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "docVenta") 
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Data
public class DocVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocVenta;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha; 
	 
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "idCliente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Cliente cliente; 
	

	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "idEmpleado")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Empleado empleado; 
}
