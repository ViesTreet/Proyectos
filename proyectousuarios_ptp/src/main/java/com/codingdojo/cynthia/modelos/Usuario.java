package com.codingdojo.cynthia.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AI
	private long id;
	/////////--------
	
	@NotNull //@NotEmpty
	@Size(min=2, max=100, message="El nombre debe de tener al menos 2 caracteres")
	private String nombre;
	
	@NotNull
	@Size(min=2, max=100)
	private String apellido;
	
	@NotNull
	@Size(min=2, max=200)
	private String email;
	
	@NotNull
	@Size(min=6, max=255) //En un futuro vamos a encriptarla
	private String password;
	
	@Column(updatable=false) //Este atributo solamente se ingresa una vez, y NUNCA se actualiza
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToOne(mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Direccion direccion;
	
	public Usuario() {
	}
	
	//Crear un nuevo usuario
	public Usuario(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	
	//Actualizar un usuario
	public Usuario(long id, String nombre, String apellido, String email, String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@PrePersist //Antes de hacer la creación
	protected void onCreate() {
		this.createdAt = new Date(); //DEFAULT CURRENT_TIMESTAMP
	}
	
	@PreUpdate //Antes de hacer una actualización
	protected void onUpdate() {
		this.updatedAt = new Date(); //DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}
	
}
