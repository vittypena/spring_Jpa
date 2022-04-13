package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facturas_items")
public class ItemFactura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2910858375045097527L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	private Integer cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)		//Por pone producto_id, pero se puede especificar //@JoinColumn(name="producto_id")
	private Producto producto;

	public Double calcularImporte() {
		return cantidad.doubleValue()* producto.getPrecio();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}