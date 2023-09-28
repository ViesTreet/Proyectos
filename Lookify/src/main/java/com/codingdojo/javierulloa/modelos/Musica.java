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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="musicas")
public class Musica {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	
	@NotNull
	@Size(min=2, max=100)
	private String nombre;
	
	@NotNull
	@Size(min=2, max=100)
	private String autor;
	
	@NotNull
	@Min(1)
	@Max(10)
	private int calificacion;
	

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

	public Musica() {
	}

	public Musica(@NotEmpty @Size(min = 2, max = 100) String nombre, @NotEmpty @Size(min = 2, max = 100) String autor,
			@NotEmpty @Min(1) @Max(10) int calificacion) {
		this.nombre = nombre;
		this.autor = autor;
		this.calificacion = calificacion;
	}

	public Musica(long id, @NotEmpty @Size(min = 2, max = 100) String nombre,
			@NotEmpty @Size(min = 2, max = 100) String autor, @NotEmpty @Min(1) @Max(10) int calificacion) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.calificacion = calificacion;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
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
