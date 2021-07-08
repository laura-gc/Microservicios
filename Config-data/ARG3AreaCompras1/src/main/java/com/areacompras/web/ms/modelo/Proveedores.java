package com.areacompras.web.ms.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")

//Permite crear un constructor que llame a todos los atributos
@AllArgsConstructor
//Permite crear un constructor vacio
@NoArgsConstructor
//Para crear nuevas instancias de la entidad
@Builder
//Para utilizar los metodos "Get" y "Set": "@Data" o "@Getter @Setter"
@Data

public class Proveedores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	
	private String Ruc;
	private String RazonSocial;
	private String Telefono;
	private String Correo;
	private String Direccion;
	
	@Column(name = "FechaRegistro")
	@Temporal(TemporalType.DATE)	//Para trabajar con fechas	
	private Date FechaRegistro;
	
}
