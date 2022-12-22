package co.edu.ubosque.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EstadoCivil", schema = "dbo", catalog = "teemplea")
public class EstadoCivil implements java.io.Serializable {

	private Integer id;
	private String descripcion;

	public EstadoCivil() {
	}

	public EstadoCivil(String descripcion) {
		this.descripcion = descripcion;
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

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

