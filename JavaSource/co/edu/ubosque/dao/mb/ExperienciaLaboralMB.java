package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.ExperienciaLaboralLogica;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.Usuario;



@ManagedBean
@SessionScoped
public class ExperienciaLaboralMB {

	private ExperienciaLaboralLogica logica;
	private List<ExperienciaLaboral> listaExperienciasLaborales;
	private List<ExperienciaLaboral> experiencia;
	private List<ExperienciaLaboral> validar;
	private ExperienciaLaboral experienciaLaboralACrear;
	private ExperienciaLaboral experienciaLaboralAModificar;
	private ExperienciaLaboral experienciaLaboralAEliminar;
	private ExperienciaLaboral experiencias;
	int cedula1;

	public ExperienciaLaboralMB() {
		
		experiencias = new ExperienciaLaboral();
		logica = new ExperienciaLaboralLogica();
		listaExperienciasLaborales = logica.readExperienciaLaboral();

	}

	public String guardarExperienciaLaboral( ) {

		logica.createExperienciaLaboral(experienciaLaboralACrear);
		listaExperienciasLaborales = logica.readExperienciaLaboral();

		return "perfilUsuario";
	}

	public String actualizarExperienciaLaboral() {

		logica.updateExperienciaLaboral(experienciaLaboralAModificar);
		listaExperienciasLaborales = logica.readExperienciaLaboral();

		return "/informacionUsuario/perfilUsuario";
	}

	public void borrarExperienciaLaboral() {

		logica.deleteExperienciaLaboral(experienciaLaboralAEliminar);
		listaExperienciasLaborales = logica.readExperienciaLaboral();
	}

	public String inicializarExperienciaLaboralACrear() {

		experienciaLaboralACrear = new ExperienciaLaboral();

		return "/informacionUsuario/crearExperiencia";
	}
	
	public boolean cargar() {
		
	try {
		
		cargarExperiencia(cedula1);
		
		return true;
		
	} catch (Exception e) {
		System.out.println(e);
		return true;
	}
	}

	public boolean cargarExperiencia( long cedula ) {
				
		this.cedula1 = (int) cedula;
		try {
			
			experiencia = logica.cargarExperiencia(cedula1);
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return true;
		} 

		
	}

	public List<ExperienciaLaboral> getListaExperienciasLaborales() {
		return listaExperienciasLaborales;
	}

	public void setListaExperienciasLaborales(List<ExperienciaLaboral> listaExperienciasLaborales) {
		this.listaExperienciasLaborales = listaExperienciasLaborales;
	}

	public List<ExperienciaLaboral> getValidar() {
		return validar;
	}

	public void setValidar(List<ExperienciaLaboral> validar) {
		this.validar = validar;
	}

	public ExperienciaLaboralLogica getLogica() {
		return logica;
	}

	public List<ExperienciaLaboral> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<ExperienciaLaboral> experiencia) {
		this.experiencia = experiencia;
	}

	public int getCedula1() {
		return cedula1;
	}

	public void setCedula1(int cedula1) {
		this.cedula1 = cedula1;
	}

	public void setLogica(ExperienciaLaboralLogica logica) {
		this.logica = logica;
	}

	public ExperienciaLaboral getExperienciaLaboralACrear() {
		return experienciaLaboralACrear;
	}

	public void setExperienciaLaboralACrear(ExperienciaLaboral experienciaLaboralACrear) {
		this.experienciaLaboralACrear = experienciaLaboralACrear;
	}

	public ExperienciaLaboral getExperienciaLaboralAModificar() {
		return experienciaLaboralAModificar;
	}

	public void setExperienciaLaboralAModificar(ExperienciaLaboral experienciaLaboralAModificar) {
		this.experienciaLaboralAModificar = experienciaLaboralAModificar;
	}

	public ExperienciaLaboral getExperienciaLaboralAEliminar() {
		return experienciaLaboralAEliminar;
	}

	public void setExperienciaLaboralAEliminar(ExperienciaLaboral experienciaLaboralAEliminar) {
		this.experienciaLaboralAEliminar = experienciaLaboralAEliminar;
	}

	public ExperienciaLaboral getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(ExperienciaLaboral experiencias) {
		this.experiencias = experiencias;
	}


}
