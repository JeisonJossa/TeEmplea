package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.OfertaLaboralLogica;
import co.edu.ubosque.model.OfertaLaboral;

@ManagedBean
@SessionScoped
public class OfertaLaboralMB {

	private OfertaLaboralLogica logica;
	private List<OfertaLaboral> listaOfertaLaboral;
	private OfertaLaboral ofertaLaboralACrear;
	private OfertaLaboral ofertaLaboralAModificar;
	private OfertaLaboral ofertaLaboralAEliminar;
	private OfertaLaboral ofertaLaboralSeleccionada;

	public OfertaLaboralMB() {

		ofertaLaboralACrear = new OfertaLaboral();
		logica = new OfertaLaboralLogica();
		listaOfertaLaboral = logica.readOfertaLaboral();

	}

	public String guardarOfertaLaboral( ) {

		String basico = null;

		try {

			logica.CreateOfertaLaboral(ofertaLaboralACrear);
			listaOfertaLaboral = logica.readOfertaLaboral();

			basico = "/compania/perfilCompania";

		} catch (Exception e) {
			System.out.println(e);
		}
		return basico;
	}

	public String actualizarOfertaLaboral() {

		logica.updateOfertaLaboral(ofertaLaboralAModificar);
		listaOfertaLaboral = logica.readOfertaLaboral();

		return "/compania/perfilCompania";
	}

	public void borrarOfertaLaboral() {

		logica.deleteOfertaLaboral(ofertaLaboralAEliminar);
		listaOfertaLaboral = logica.readOfertaLaboral();
	}

	public String inicializarOfertaLaboral() {

		ofertaLaboralACrear = new OfertaLaboral();

		return "publicarOferta";
	}

	
	public String ofertas() {
		
		ofertaLaboralSeleccionada = new OfertaLaboral();
		
		return "/ofertas/ofertasEmpleo";
	}
	
	
	
	public OfertaLaboralLogica getLogica() {
		return logica;
	}

	public void setLogica(OfertaLaboralLogica logica) {
		this.logica = logica;
	}

	public List<OfertaLaboral> getListaOfertaLaboral() {
		return listaOfertaLaboral;
	}

	public void setListaOfertaLaboral(List<OfertaLaboral> listaOfertaLaboral) {
		this.listaOfertaLaboral = listaOfertaLaboral;
	}

	public OfertaLaboral getOfertaLaboralACrear() {
		return ofertaLaboralACrear;
	}

	public void setOfertaLaboralACrear(OfertaLaboral ofertaLaboralACrear) {
		this.ofertaLaboralACrear = ofertaLaboralACrear;
	}

	public OfertaLaboral getOfertaLaboralAModificar() {
		return ofertaLaboralAModificar;
	}

	public void setOfertaLaboralAModificar(OfertaLaboral ofertaLaboralAModificar) {
		this.ofertaLaboralAModificar = ofertaLaboralAModificar;
	}

	public OfertaLaboral getOfertaLaboralAEliminar() {
		return ofertaLaboralAEliminar;
	}

	public void setOfertaLaboralAEliminar(OfertaLaboral ofertaLaboralAEliminar) {
		this.ofertaLaboralAEliminar = ofertaLaboralAEliminar;
	}

	public OfertaLaboral getOfertaLaboralSeleccionada() {
		return ofertaLaboralSeleccionada;
	}

	public void setOfertaLaboralSeleccionada(OfertaLaboral ofertaLaboralSeleccionada) {
		this.ofertaLaboralSeleccionada = ofertaLaboralSeleccionada;
	}

	
	
	

	

}
