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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="libros")
public class Libro {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=100, message="el nombre debe tener mas de 2 y menos de 100 caracteres")
	private String nombre;
	
	@NotNull
	@Size(min=2, max=600)
	private String descripcion;
	
	@NotNull
	@Size(min=2, max=200)
	private String lenguaje;
	
	@NotNull
	private int paginas;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	public Libro() {
	}

	public Libro(
			@NotNull @Size(min = 2, max = 100, message = "el nombre debe tener mas de 2 y menos de 100 caracteres") String nombre,
			@NotNull @Size(min = 2, max = 100) String descripcion, @NotNull @Size(min = 2, max = 200) String lenguaje,
			@NotNull int paginas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lenguaje = lenguaje;
		this.paginas = paginas;
	}

	public Libro(long id,
			@NotNull @Size(min = 2, max = 100, message = "el nombre debe tener mas de 2 y menos de 100 caracteres") String nombre,
			@NotNull @Size(min = 2, max = 100) String descripcion, @NotNull @Size(min = 2, max = 200) String lenguaje,
			@NotNull int paginas) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lenguaje = lenguaje;
		this.paginas = paginas;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
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
