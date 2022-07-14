package com.springboot.restApi.PostgreSQL.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private Long documento;
	private String name;
	private String lastname;
	private String codigo;
	
	public Empleado() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Empleado(Long id, Long documento, String name, String lastname, String codigo) {
		super();
		this.id = id;
		this.documento = documento;
		this.name = name;
		this.lastname = lastname;
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", documento=" + documento + ", name=" + name + ", lastname=" + lastname + ", codigo="
				+ codigo + "]";
	}
}
