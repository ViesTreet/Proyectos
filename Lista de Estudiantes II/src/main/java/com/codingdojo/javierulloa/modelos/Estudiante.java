package com.codingdojo.javierulloa.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="estudiantes")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min=2 , max=100)
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dormitorio_id")
	private Dormitorio dormitorio;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Estudiante() {
	}
	
	public Estudiante(@NotEmpty @Size(min = 2, max = 100) String nombre) {
		this.nombre = nombre;
	}
	
	public Estudiante(long id, @NotEmpty @Size(min = 2, max = 100) String nombre, Dormitorio dormitorio) {
		this.id = id;
		this.nombre = nombre;
		this.dormitorio = dormitorio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dormitorio getDormitorio() {
		return dormitorio;
	}

	public void setDormitorio(Dormitorio dormitorio) {
		this.dormitorio = dormitorio;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
