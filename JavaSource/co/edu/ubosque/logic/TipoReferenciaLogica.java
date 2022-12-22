package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import co.edu.ubosque.dao.ITipoReferenciaDAO;
import co.edu.ubosque.dao.IUsuarioDAO;
import co.edu.ubosque.dao.impl.TipoReferenciaDaoSQLServerHibernate2;
import co.edu.ubosque.dao.impl.UsuarioDaoSQLServerHibernate;
import co.edu.ubosque.model.TeEmplea;
import co.edu.ubosque.model.TipoReferencia;
import co.edu.ubosque.model.Usuario;

public class TipoReferenciaLogica {

	private ITipoReferenciaDAO dao;
	private ResourceBundle rs;

	public TipoReferenciaLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new TipoReferenciaDaoSQLServerHibernate2();

		} else {
			
		}

	}


	public List<TipoReferencia> readTipoReferencia( ) {

		return dao.readTipoReferencia();
	}


	public ITipoReferenciaDAO getDao() {
		return dao;
	}


	public void setDao(ITipoReferenciaDAO dao) {
		this.dao = dao;
	}


	public ResourceBundle getRs() {
		return rs;
	}


	public void setRs(ResourceBundle rs) {
		this.rs = rs;
	}
	
	
	
}
