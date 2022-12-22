package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Entity;
import javax.swing.JOptionPane;

import co.edu.ubosque.dao.IOfertaLaboralDAO;
import co.edu.ubosque.dao.impl.OfertaLaboralDaoSQLServerHibernate;
import co.edu.ubosque.model.OfertaLaboral;

@Entity
public class OfertaLaboralLogica {
	private IOfertaLaboralDAO dao;
	private ResourceBundle rs;

	public OfertaLaboralLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new OfertaLaboralDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean CreateOfertaLaboral( OfertaLaboral ofertaLaboralACrear ) {

		boolean resultado = dao.createOfertaLaboral( ofertaLaboralACrear );

		return resultado;
	}

	public List<OfertaLaboral> readOfertaLaboral( ) {

		return dao.readOfertaLaboral();
	}

	public boolean updateOfertaLaboral( OfertaLaboral ofertaLaboralAModificar ) {

		boolean resultado = dao.updateOfertaLaboral(ofertaLaboralAModificar);

		return resultado;
	}

	public boolean deleteOfertaLaboral( OfertaLaboral ofertaLaboralAEliminar ) {

		boolean resultado = dao.deleteOfertaLaboral(ofertaLaboralAEliminar);

		return resultado;
	}

}
