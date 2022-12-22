package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.ReferenciasLogica;
import co.edu.ubosque.model.Referencias;


@ManagedBean
@SessionScoped
public class ReferenciasMB {

	private ReferenciasLogica logica;
	private List<Referencias> listaReferencias;
	private Referencias referenciasACrear;
	private Referencias referenciasAModificar;
	private Referencias referenciasAEliminar;
	
	
	public ReferenciasMB() {
		logica = new ReferenciasLogica();
		listaReferencias = logica.readReferencias();
	}
	
	public String guardarReferencias( ) {
	
		logica.createReferencias(referenciasACrear);
		listaReferencias = logica.readReferencias();
		
		return "perfilUsuario";
	}
	
	public String actualizarReferencias() {
		
		logica.updateReferencias(referenciasAModificar);
		listaReferencias = logica.readReferencias();
		
		return "perfilUsuario";
	}
	
	public void borrarReferencias() {
		
		logica.deleteReferencias(referenciasAEliminar);
		listaReferencias = logica.readReferencias();
	}
	
	public String inicializarReferenciasACrear() {
		
		referenciasACrear = new Referencias();
		
		return "crearReferencia";
	}

	public ReferenciasLogica getLogica() {
		return logica;
	}

	public void setLogica(ReferenciasLogica logica) {
		this.logica = logica;
	}

	public List<Referencias> getListaReferencias() {
		return listaReferencias;
	}

	public void setListaReferencias(List<Referencias> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

	public Referencias getReferenciasACrear() {
		return referenciasACrear;
	}

	public void setReferenciasACrear(Referencias referenciasACrear) {
		this.referenciasACrear = referenciasACrear;
	}

	public Referencias getReferenciasAModificar() {
		return referenciasAModificar;
	}

	public void setReferenciasAModificar(Referencias referenciasAModificar) {
		this.referenciasAModificar = referenciasAModificar;
	}

	public Referencias getReferenciasAEliminar() {
		return referenciasAEliminar;
	}

	public void setReferenciasAEliminar(Referencias referenciasAEliminar) {
		this.referenciasAEliminar = referenciasAEliminar;
	}

	
	
	
}
