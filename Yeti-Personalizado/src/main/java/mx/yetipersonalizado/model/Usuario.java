package mx.yetipersonalizado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO: Plain Old Java Object

@Entity
@Table (name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="idusuario", unique=true, nullable=false)
	private Long id;
	@Column (nullable=false)
	private String nombre;
	@Column (nullable=false)
	private String phone;
	@Column (unique=true, nullable=false)
	private String mail;
	@Column (nullable=false)
	private String password;
	
	public Usuario(Long id, String nombre, String phone, String mail, String password) {
		
		this.id=id;
		this.nombre = nombre;
		this.phone = phone;
		this.mail = mail;
		this.password = password;
		
	} // constructor
	
	public Usuario() {
		
	} // default constructor

	public String getNombre() {
		return nombre;
	} // getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} // setNombre

	public String getPhone() {
		return phone;
	} // getTelefono

	public void setPhone(String phone) {
		this.phone = phone;
	} // setTelefono

	public String getMail() {
		return mail;
	} // getMail

	public void setMail(String mail) {
		this.mail = mail;
	} // setMail

	public String getPassword() {
		return password;
	} // getPassword

	public void setPassword(String password) {
		this.password = password;
	} // setPassword

	public Long getId() {
		return id;
	} // getId

	public void setId(Long id) {
		this.id = id;
	} // setId

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", phone=" + phone + ", mail=" + mail + ", password="
				+ password + "]";
	}// toString
	
} // class Usuario
