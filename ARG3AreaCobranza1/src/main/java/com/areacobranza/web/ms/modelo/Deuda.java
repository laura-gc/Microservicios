package com.areacobranza.web.ms.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deuda")

//Permite crear un constructor que llame a todos los atributos
@AllArgsConstructor
//Permite crear un constructor vacio
@NoArgsConstructor
//Para crear nuevas instancias de la entidad
@Builder
//Para utilizar los metodos "Get" y "Set": "@Data" o "@Getter @Setter"
@Data

public class Deuda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeuda;
	
	//Nombre del atributo que define la relacion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDocVenta")
	//OBS:
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private DocVenta docVenta;
	
	private Double monto;
	
	private String estado;
	
	@Column(name = "fechaPago")
	@Temporal(TemporalType.TIMESTAMP)	//Para trabajar con fechas	
	private Date fechaPago;
}
