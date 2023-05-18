package mx.yetipersonalizado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO: Plain Old Java Object

@Entity
@Table (name="productos")
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="idproductos", unique= true, nullable=false)
	private int id;
	@Column (nullable=false)
	private String nombre;
	@Column (nullable=false)
	private int precio;
	@Column (nullable=false)
	private String descripcion;
	@Column (name= "idcategoria", nullable=false)
	private int categoria;
	@Column 
	private String imagen;
	
	public Producto(String nombre, int precio, String descripcion, int categoria, String imagen) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.imagen = imagen;
		
	} // constructor 
	
	public Producto() {
	} // default constructor

	public String getNombre() {
		return nombre;
	} // getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} // setNombre

	public String getDescripcion() {
		return descripcion;
	} // getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} // setDescripcion

	public String getImagen() {
		return imagen;
	} // getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	} // setImagen
	
	public int getCategoria() {
		return categoria;
	} // getCategoria

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	} // setCategoria

	public int getPrecio() {
		return precio;
	} // getPrecio

	public void setPrecio(int precio) {
		this.precio = precio;
	} // setPrecio

	public int getId() {
		return id;
	} // getId

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", imagen=" + imagen + "]";
	} //toString

	
	} // class Producto