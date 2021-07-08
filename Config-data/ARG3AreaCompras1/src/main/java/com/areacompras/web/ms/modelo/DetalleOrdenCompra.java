package com.areacompras.web.ms.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalleordencompra")

//Permite crear un constructor que llame a todos los atributos
@AllArgsConstructor
//Permite crear un constructor vacio
@NoArgsConstructor
//Para crear nuevas instancias de la entidad
@Builder
//Para utilizar los metodos "Get" y "Set": "@Data" o "@Getter @Setter"
@Data
public class DetalleOrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleOrdenCompra;
	
	private int cantidad;
	private Double precio;
	
	//Notación que permite definir una relación de muchos a uno
	@ManyToOne
	
	//Nombre del atributo que define la relacion
	@JoinColumn(name = "idOrdenCompra")
	private OrdenCompra ordenCompra;
	
	//Nombre del atributo que define la relacion
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Productos productos;
	
}
