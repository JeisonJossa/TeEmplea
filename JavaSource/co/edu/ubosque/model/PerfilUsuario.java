package co.edu.ubosque.model;
// Generated 23/11/2020, 10:27:51 p.�m. by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PerfilUsuario generated by hbm2java
 */
@Entity
@Table(name = "PerfilUsuario", schema = "dbo", catalog = "teemplea")
public class PerfilUsuario implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private Set<CrearCuenta> crearCuentas = new HashSet<CrearCuenta>(0);

	public PerfilUsuario() {
	}

	public PerfilUsuario(String nombre) {
		this.nombre = nombre;
	}

	public PerfilUsuario(String nombre, Set<CrearCuenta> crearCuentas) {
		this.nombre = nombre;
		this.crearCuentas = crearCuentas;
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

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfilUsuario")
	public Set<CrearCuenta> getCrearCuentas() {
		return this.crearCuentas;
	}

	public void setCrearCuentas(Set<CrearCuenta> crearCuentas) {
		this.crearCuentas = crearCuentas;
	}

}