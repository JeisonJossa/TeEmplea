package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.TipoReferenciaLogica;
import co.edu.ubosque.model.TipoReferencia;

@ManagedBean
@SessionScoped
public class TipoReferenciaMB {

	private TipoReferenciaLogica logica;
	private List<TipoReferencia> listaReferencias;
	private TipoReferencia referencia;
	

	public TipoReferenciaMB() {

		logica 				= new TipoReferenciaLogica();
		referencia 			= new TipoReferencia();
		listaReferencias 	= logica.readTipoReferencia();		

	}


	public TipoReferenciaLogica getLogica() {
		return logica;
	}


	public void setLogica(TipoReferenciaLogica logica) {
		this.logica = logica;
	}


	public List<TipoReferencia> getListaReferencias() {
		return listaReferencias;
	}


	public void setListaReferencias(List<TipoReferencia> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}


	public TipoReferencia getReferencia() {
		return referencia;
	}


	public void setReferencia(TipoReferencia referencia) {
		this.referencia = referencia;
	}


}
