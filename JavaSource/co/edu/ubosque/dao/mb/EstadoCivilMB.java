package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.EstadoCivilLogica;
import co.edu.ubosque.model.EstadoCivil;


@ManagedBean
@SessionScoped
public class EstadoCivilMB {
	
	private EstadoCivilLogica logica;
	private List<EstadoCivil> listaEstadoCivil;
	private EstadoCivil estadoCivilACrear;
	private EstadoCivil estadoCivilAModificar;
	private EstadoCivil estadoCivilAEliminar;

	public EstadoCivilMB() {
		
		logica = new EstadoCivilLogica();
		listaEstadoCivil = logica.readEstadoCivil();
	}
	
	public String guardarEstadoCivil( ) {
		
		logica.CreateEstadoCivil( estadoCivilACrear );
		listaEstadoCivil = logica.readEstadoCivil();
		
		return "listaSectores";
	}
	
	public String actualizarEstadoCivil() {
		
		logica.updateEstadoCivil(estadoCivilAModificar);
		listaEstadoCivil = logica.readEstadoCivil();
		
		return "listaSectores";
	}
	
	public String inicializarEstadoCivil() {
		
		estadoCivilACrear = new EstadoCivil();
		
		return "crearSector";
	}
	
	public void borrarEstadoCivil() {
		
		logica.deleteEstadoCivil(estadoCivilAEliminar);
		listaEstadoCivil = logica.readEstadoCivil();
	}

	public List<EstadoCivil> getListaEstadoCivil() {
		
		return listaEstadoCivil;
	}
	
	

	public EstadoCivilLogica getLogica() {
		return logica;
	}

	public void setLogica(EstadoCivilLogica logica) {
		this.logica = logica;
	}

	public EstadoCivil getEstadoCivilACrear() {
		return estadoCivilACrear;
	}

	public void setEstadoCivilACrear(EstadoCivil estadoCivilACrear) {
		this.estadoCivilACrear = estadoCivilACrear;
	}

	public void setListaEstadoCivil(List<EstadoCivil> listaEstadoCivil) {
		this.listaEstadoCivil = listaEstadoCivil;
	}

	public EstadoCivil getEstadoCivilAModificar() {
		return estadoCivilAModificar;
	}

	public void setEstadoCivilAModificar(EstadoCivil estadoCivilAModificar) {
		this.estadoCivilAModificar = estadoCivilAModificar;
	}

	public EstadoCivil getEstadoCivilAEliminar() {
		return estadoCivilAEliminar;
	}

	public void setEstadoCivilAEliminar(EstadoCivil estadoCivilAEliminar) {
		this.estadoCivilAEliminar = estadoCivilAEliminar;
	}
	
 
}