package com.AreaVentas.web.api.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Kardex")
@AllArgsConstructor
@NoArgsConstructor 
@Builder
@Data
public class Kardex {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idkardex;
	
	private String tipomov;
	private Long iddocumento;
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idalmacen")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Almacen almacen;
}
