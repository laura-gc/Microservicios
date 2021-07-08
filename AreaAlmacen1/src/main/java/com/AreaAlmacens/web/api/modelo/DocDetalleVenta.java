package com.AreaAlmacens.web.api.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "docDetalleVenta")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocDetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docDetalleVenta;
	
	private Long cantidad;
	private Float precio;
	private Float descuento;
	private Float total;  
	 
	@ManyToOne(fetch = FetchType.LAZY)  
	@JoinColumn(name = "idProducto")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "idDocVenta")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private DocVenta docVenta;
}
