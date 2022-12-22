package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.ubosque.dao.ITipoDocumentoDAO;
import co.edu.ubosque.dao.impl.TipoDocumentoDaoSQLServerHibernate;
import co.edu.ubosque.model.TipoDocumento;

public class TipoDocumentoLogica {

	private ITipoDocumentoDAO dao;
	private ResourceBundle rs;

	public TipoDocumentoLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new TipoDocumentoDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean CreateTipoDocumento( TipoDocumento tipoDocumentoACrear ) {

		boolean resultado = dao.createTipoDocumento( tipoDocumentoACrear );

		return resultado;
	}

	public List<TipoDocumento> readTipoDocumento( ) {

		return dao.readTipoDocumento();
	}

	public boolean updateTipoDocumento( TipoDocumento tipoDocumentoAModificar ) {

		boolean resultado = dao.updateTipoDocumento(tipoDocumentoAModificar);

		return resultado;
	}

	public boolean deleteTipoDocumento( TipoDocumento tipoDocumentoAEliminar ) {

		boolean resultado = dao.deleteTipoDocumento(tipoDocumentoAEliminar);

		return resultado;
	}	

}
