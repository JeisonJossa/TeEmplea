package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.ubosque.dao.IEstadoCivilDAO;
import co.edu.ubosque.dao.impl.EstadoCivilDaoSQLServerHibernate;
 
import co.edu.ubosque.model.EstadoCivil;
 

 


public class EstadoCivilLogica {

	private IEstadoCivilDAO dao;
	private ResourceBundle rs;

	public EstadoCivilLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new EstadoCivilDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean CreateEstadoCivil( EstadoCivil estadoCivilACrear ) {

		boolean resultado = dao.createEstadoCivil( estadoCivilACrear );

		return resultado;
	}
	 

	public List<EstadoCivil> readEstadoCivil( ) {

		return dao.readEstadoCivil();
	}
 
	public boolean updateEstadoCivil( EstadoCivil estadoCivilAModificar ) {

		boolean resultado = dao.updateEstadoCivil(estadoCivilAModificar);

		return resultado;
	}

	public boolean deleteEstadoCivil( EstadoCivil estadoCivilAEliminar ) {

		boolean resultado = dao.deleteEstadoCivil(estadoCivilAEliminar);

		return resultado;
	}

}
