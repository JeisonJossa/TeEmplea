package co.edu.ubosque.model;
// Generated 23/11/2020, 10:27:51 p. m. by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Referencias generated by hbm2java
 */
@Entity
@Table(name = "Referencias", schema = "dbo", catalog = "teemplea")
public class Referencias implements java.io.Serializable {

	private Integer id;
	private int identificacion;
	private String tipoReferencia;
	private String nombre;
	private String cargo;
	private Integer telefono;
	private String direccion;

	public Referencias() {
	}

	public Referencias(int identificacion) {
		this.identificacion = identificacion;
	}

	public Referencias(int identificacion, String tipoReferencia, String nombre, String cargo, Integer telefono,
			String direccion) {
		this.identificacion = identificacion;
		this.tipoReferencia = tipoReferencia;
		this.nombre = nombre;
		this.cargo = cargo;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "identificacion", nullable = false)
	public int getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	@Column(name = "tipoReferencia", length = 50)
	public String getTipoReferencia() {
		return this.tipoReferencia;
	}

	public void setTipoReferencia(String tipoReferencia) {
		this.tipoReferencia = tipoReferencia;
	}

	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "cargo", length = 50)
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "telefono")
	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Column(name = "direccion", length = 50)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
