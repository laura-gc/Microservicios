package com.AreaVentas.web.api.modelo;

import javax.persistence.*; 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Producto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproducto;
	
	private String nombre;
	private Double precio;
	private Long stock;
	private String status; 
}
