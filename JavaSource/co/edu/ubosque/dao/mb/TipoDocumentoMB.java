package co.edu.ubosque.dao.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import co.edu.ubosque.logic.TipoDocumentoLogica;
import co.edu.ubosque.model.TipoDocumento;

@ManagedBean
public class TipoDocumentoMB {

	private TipoDocumentoLogica logica;
	private List<TipoDocumento> listaTipoDocumento;
	private TipoDocumento tipoDocumentoACrear;
	private TipoDocumento tipoDocumentoAModificar;
	private TipoDocumento tipoDocumentoAEliminar;

	public TipoDocumentoMB() {
		
		logica = new TipoDocumentoLogica();
		listaTipoDocumento = logica.readTipoDocumento();
	}
	
	public String guardarTipoDocumento( ) {
		
		logica.CreateTipoDocumento( tipoDocumentoACrear );
		listaTipoDocumento = logica.readTipoDocumento();
		
		return "crearCuenta";
	}
	
	public String actualizarTipoDocumento() {
		
		logica.updateTipoDocumento(tipoDocumentoAModificar);
		listaTipoDocumento = logica.readTipoDocumento();
		
		return "crearCuenta";
	}
	
	public void borrarTipoDocumento() {
		
		logica.deleteTipoDocumento(tipoDocumentoAEliminar);
		listaTipoDocumento = logica.readTipoDocumento();
	}
	
	public String inicializarTipoDocumentoACrear() {
		
		tipoDocumentoACrear = new TipoDocumento();
		
		return "crearCuenta";
	}

	public TipoDocumentoLogica getLogica() {
		return logica;
	}

	public void setLogica(TipoDocumentoLogica logica) {
		this.logica = logica;
	}

	public List<TipoDocumento> getListaTipoDocumento() {
		return listaTipoDocumento;
	}

	public void setListaTipoDocumento(List<TipoDocumento> listaTipoDocumento) {
		this.listaTipoDocumento = listaTipoDocumento;
	}

	public TipoDocumento getTipoDocumentoACrear() {
		return tipoDocumentoACrear;
	}

	public void setTipoDocumentoACrear(TipoDocumento tipoDocumentoACrear) {
		this.tipoDocumentoACrear = tipoDocumentoACrear;
	}

	public TipoDocumento getTipoDocumentoAModificar() {
		return tipoDocumentoAModificar;
	}

	public void setTipoDocumentoAModificar(TipoDocumento tipoDocumentoAModificar) {
		this.tipoDocumentoAModificar = tipoDocumentoAModificar;
	}

	public TipoDocumento getTipoDocumentoAEliminar() {
		return tipoDocumentoAEliminar;
	}

	public void setTipoDocumentoAEliminar(TipoDocumento tipoDocumentoAEliminar) {
		this.tipoDocumentoAEliminar = tipoDocumentoAEliminar;
	}



}
