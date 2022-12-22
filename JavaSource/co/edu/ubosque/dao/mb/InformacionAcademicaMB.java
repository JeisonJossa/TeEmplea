package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.InformacionAcademicaLogica;
import co.edu.ubosque.model.InformacionAcademica;




@ManagedBean
@SessionScoped
public class InformacionAcademicaMB {

	private InformacionAcademicaLogica logica;
	private List<InformacionAcademica> listaInformacionAcademica;
	private InformacionAcademica informacionAcademicaACrear;
	private InformacionAcademica informacionAcademicaAModificar;
	private InformacionAcademica informacionAcademicaAEliminar;


	public InformacionAcademicaMB() {

		logica = new InformacionAcademicaLogica();
		listaInformacionAcademica = logica.readInformacionAcademica();
	}

	public String guardarInformacionAcademica( ) {

		logica.createInformacionAcademica(informacionAcademicaACrear);
		listaInformacionAcademica = logica.readInformacionAcademica();

		return "perfilUsuario";
	}

	public String actualizarInformacionAcademica() {

		logica.updateInformacionAcademica(informacionAcademicaAModificar);
		listaInformacionAcademica = logica.readInformacionAcademica();

		return "perfilUsuario";
	}

	public void borrarInformacionAcademica() {

		logica.deleteInformacionAcademica(informacionAcademicaAEliminar);
		listaInformacionAcademica = logica.readInformacionAcademica();
	}

	public String inicializarInformacionAcademicaACrear() {

		informacionAcademicaACrear = new InformacionAcademica();

		return "crearInformacionAcademica";
	}



	public List<InformacionAcademica> getListaInformacionAcademica() {
		return listaInformacionAcademica;
	}

	public void setListaInformacionAcademica(List<InformacionAcademica> listaInformacionAcademica) {
		this.listaInformacionAcademica = listaInformacionAcademica;
	}

	public InformacionAcademica getInformacionAcademicaACrear() {
		return informacionAcademicaACrear;
	}

	public void setInformacionAcademicaACrear(InformacionAcademica informacionAcademicaACrear) {
		this.informacionAcademicaACrear = informacionAcademicaACrear;
	}

	public InformacionAcademica getInformacionAcademicaAModificar() {
		return informacionAcademicaAModificar;
	}

	public void setInformacionAcademicaAModificar(InformacionAcademica informacionAcademicaAModificar) {
		this.informacionAcademicaAModificar = informacionAcademicaAModificar;
	}

	public InformacionAcademica getInformacionAcademicaAEliminar() {
		return informacionAcademicaAEliminar;
	}

	public void setInformacionAcademicaAEliminar(InformacionAcademica informacionAcademicaAEliminar) {
		this.informacionAcademicaAEliminar = informacionAcademicaAEliminar;
	}



}
