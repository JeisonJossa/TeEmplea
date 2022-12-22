package co.edu.ubosque.logic;



import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import co.edu.ubosque.dao.IInformacionAcademicaDAO;
import co.edu.ubosque.dao.impl.InformacionAcademicaDaoSQLServerHibernate;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.InformacionAcademica;


public class InformacionAcademicaLogica {

	private IInformacionAcademicaDAO dao;
	private ResourceBundle rs;

	public InformacionAcademicaLogica() {
		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new InformacionAcademicaDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean createInformacionAcademica( InformacionAcademica informacionAcademicaACrear ) {

		boolean resultado = dao.createInformacionAcademica(informacionAcademicaACrear);

		return resultado;
	}

	public List<InformacionAcademica> readInformacionAcademica( ) {

		return dao.readInformacionAcademica();
	}
	
	public List<InformacionAcademica> cargarAcademica( int cargarAcademica ) {

		return dao.cargarInformacionAcademica( cargarAcademica );
	}

	public boolean updateInformacionAcademica( InformacionAcademica informacionAcademicaAModificar ) {

		boolean resultado = dao.updateInformacionAcademica(informacionAcademicaAModificar);

		return resultado;
	}

	public boolean deleteInformacionAcademica( InformacionAcademica informacionAcademicaAEliminar ) {

		boolean resultado = dao.deleteInformacionAcademica(informacionAcademicaAEliminar);

		return resultado;
	}

}
