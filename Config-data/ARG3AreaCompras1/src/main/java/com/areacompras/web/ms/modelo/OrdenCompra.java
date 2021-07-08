package com.areacompras.web.ms.modelo;

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
@Table(name = "ordencompra")

//Permite crear un constructor que llame a todos los atributos
@AllArgsConstructor
//Permite crear un constructor vacio
@NoArgsConstructor
//Para crear nuevas instancias de la entidad
@Builder
//Para utilizar los metodos "Get" y "Set": "@Data" o "@Getter @Setter"
@Data
public class OrdenCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdenCompra;
	
	private String Descripcion;
	
	@Column(name = "FechaCompra")
	@Temporal(TemporalType.TIMESTAMP)	//Para trabajar con fechas	
	private Date FechaCompra;
	
	//Notación que permite definir una relación de muchos a uno
	@ManyToOne(fetch = FetchType.LAZY)
	//Nombre del atributo que define la relacion
	@JoinColumn(name = "idEmpleado")
	//OBS:
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Empleados empleados;
	
	//Nombre del atributo que define la relacion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProveedor")
	//OBS:
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Proveedores proveedores;

}
