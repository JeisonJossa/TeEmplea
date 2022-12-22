package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.edu.ubosque.logic.SectorLogica;
import co.edu.ubosque.model.Sector;


@ManagedBean
@SessionScoped
public class SectorMB {
	
	private SectorLogica logica;
	private List<Sector> listaSectores;
	private Sector sectorACrear;
	private Sector sectorAModificar;
	private Sector sectorAEliminar;

	public SectorMB() {
		
		logica = new SectorLogica();
		listaSectores = logica.readSector();
	}
	
	public String guardarSector( ) {
		
		logica.CreateSector( sectorACrear );
		listaSectores = logica.readSector();
		
		return "listaSectores";
	}
	
	public String actualizarSector() {
		
		logica.updateSector(sectorAModificar);
		listaSectores = logica.readSector();
		
		return "listaSectores";
	}
	
	public void borrarSector() {
		
		logica.deleteSector(sectorAEliminar);
		listaSectores = logica.readSector();
	}
	
	public String inicializarSectorACrear() {
		
		sectorACrear = new Sector();
		
		return "crearSector";
	}

	public List<Sector> getListaSectores() {
		
		return listaSectores;
	}

	public void setListaSectores(List<Sector> listaSectores) {
		this.listaSectores = listaSectores;
	}

	public Sector getSectorACrear() {
		return sectorACrear;
	}

	public void setSectorACrear(Sector sectorACrear) {
		this.sectorACrear = sectorACrear;
	}

	public Sector getSectorAModificar() {
		return sectorAModificar;
	}

	public void setSectorAModificar(Sector sectorAModificar) {
		this.sectorAModificar = sectorAModificar;
	}

	public Sector getSectorAEliminar() {
		return sectorAEliminar;
	}

	public void setSectorAEliminar(Sector sectorAEliminar) {
		this.sectorAEliminar = sectorAEliminar;
	}

}