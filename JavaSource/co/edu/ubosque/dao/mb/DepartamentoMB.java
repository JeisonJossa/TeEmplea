package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.DepartamentoLogica;
import co.edu.ubosque.model.Departamento;






@ManagedBean
@SessionScoped
public class DepartamentoMB {
	
	private DepartamentoLogica logica;
	private List<Departamento> listaDepartamento;
	private Departamento departamentoACrear;
	private Departamento departamentoAModificar;
	private Departamento departamentoAEliminar;
	

	public DepartamentoMB() {
		
		logica = new DepartamentoLogica();
		listaDepartamento = logica.readDepartamento();
	}
	
	public String guardarDepartamento( ) {
		
		logica.CreateDepartamento( departamentoACrear );
		listaDepartamento = logica.readDepartamento();
		
		return "listaSectores";
	}
	
	
	public List<Departamento> getListaDepartamento() {
		
		return listaDepartamento;
	}
public String actualizarDepartamento() {
		
		logica.updateDepartamento(departamentoAModificar);
		listaDepartamento = logica.readDepartamento();
		
		return "listaSectores";
	}
	
	public void borrarDepartamento() {
		
		logica.deleteDepartamento(departamentoAEliminar);
		listaDepartamento = logica.readDepartamento();
	}
	
	public String inicializarDepartamentoACrear() {
		
		departamentoACrear = new Departamento();
		
		return "crearSector";
	}
	

	public DepartamentoLogica getLogica() {
		return logica;
	}

	public void setLogica(DepartamentoLogica logica) {
		this.logica = logica;
	}

	public Departamento getDepartamentoACrear() {
		return departamentoACrear;
	}

	public void setDepartamentoACrear(Departamento departamentoACrear) {
		this.departamentoACrear = departamentoACrear;
	}

	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	public Departamento getDepartamentoAModificar() {
		return departamentoAModificar;
	}

	public void setDepartamentoAModificar(Departamento departamentoAModificar) {
		this.departamentoAModificar = departamentoAModificar;
	}

	public Departamento getDepartamentoAEliminar() {
		return departamentoAEliminar;
	}

	public void setDepartamentoAEliminar(Departamento departamentoAEliminar) {
		this.departamentoAEliminar = departamentoAEliminar;
	}

	 
	

}