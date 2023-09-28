package com.codingdojo.javierulloa.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="lenguajes")
public class Lenguaje {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=100)
	private String nombre;
	
	@NotNull
	@Size(min=2, max=100)
	private String creador;
	
	
	@NotEmpty
	@Size(min=1, max=100)
	private String version;

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Lenguaje() {
	}

	public Lenguaje(@NotNull @Size(min = 2, max = 100) String nombre, @NotNull @Size(min = 2, max = 100) String creador,
			@NotEmpty @Size(min = 2, max = 100) String version) {
		this.nombre = nombre;
		this.creador = creador;
		this.version = version;
	}

	public Lenguaje(long id, @NotNull @Size(min = 2, max = 100) String nombre,
			@NotNull @Size(min = 2, max = 100) String creador, @NotEmpty @Size(min = 2, max = 100) String version) {
		this.id = id;
		this.nombre = nombre;
		this.creador = creador;
		this.version = version;
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

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
	
	
}
