package com.AreaVentas.web.api.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Entity
@Table(name = "Almacen")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalmacen;
	
	private String nombre;
	private String capacidad;
}
