package com.AreaVentas.web.api.modelo;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 


@Entity
@Table(name = "DetalleKardex")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetalleKardex {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetallekardex;
	
	
	
	private String status;
	private Long cantidad;
	
	
	@ManyToOne
	@JoinColumn(name = "idKardex")
	private Kardex kardex;
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
}
