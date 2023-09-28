package com.codingdojo.javierulloa.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min=2 ,max=100)
	private String nombre;
	
	@NotEmpty
	@Size(min=2 ,max=100)
	private String apellido;
	
	@NotEmpty
	@Size(min=2 ,max=100)
	private String email;
	
	@NotEmpty
	@Size(min=2 ,max=100)
	private String contrasena;
	
	@Transient 
	@Size(min=2 ,max=100)
	private String confirmacion;
	
	@OneToMany(mappedBy="lider",fetch=FetchType.LAZY)
	private List<Proyecto> misProyectos;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="proyecto_con_usuario",
			joinColumns=@JoinColumn(name="usuario_id"),
			inverseJoinColumns=@JoinColumn(name="proyecto_id")
			)
	private List<Proyecto> proyectoUnidos;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Usuario() {
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}
	
	public List<Proyecto> getProyectoUnidos() {
		return proyectoUnidos;
	}

	public void setProyectoUnidos(List<Proyecto> proyectoUnidos) {
		this.proyectoUnidos = proyectoUnidos;
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
	
	public List<Proyecto> getMisProyectos() {
		return misProyectos;
	}

	public void setMisProyectos(List<Proyecto> misProyectos) {
		this.misProyectos = misProyectos;
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
