package co.edu.ubosque.model;
// Generated 23/11/2020, 10:27:51 p. m. by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrearCuenta generated by hbm2java
 */
@Entity
@Table(name = "CrearCuenta", schema = "dbo", catalog = "teemplea")
public class CrearCuenta implements java.io.Serializable {

	private Integer identificacion;
	private PerfilUsuario perfilUsuario;
	private TipoDocumento tipoDocumento;
	private int id;
	private String correo;
	private String contrasena;
	private Date fechaCreacion;

	public CrearCuenta() {
	}

	public CrearCuenta(int id, String correo, String contrasena) {
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public CrearCuenta(PerfilUsuario perfilUsuario, TipoDocumento tipoDocumento, int id, String correo,
			String contrasena, Date fechaCreacion) {
		this.perfilUsuario = perfilUsuario;
		this.tipoDocumento = tipoDocumento;
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "identificacion", unique = true, nullable = false)
	public Integer getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(Integer identificacion) {
		this.identificacion = identificacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil")
	public PerfilUsuario getPerfilUsuario() {
		return this.perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoDocumento")
	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "correo", nullable = false, length = 50)
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "contrasena", nullable = false, length = 50)
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaCreacion", length = 10)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
