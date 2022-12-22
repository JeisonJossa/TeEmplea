package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.ubosque.dao.IExperienciaLaboralDAO;
import co.edu.ubosque.dao.impl.ExperienciaDaoSQLServerHibernate;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.Usuario;


public class ExperienciaLaboralLogica {

	private IExperienciaLaboralDAO dao;
	private ResourceBundle rs;

	public ExperienciaLaboralLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new ExperienciaDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean createExperienciaLaboral( ExperienciaLaboral experienciaLaboralACrear ) {

		boolean resultado = dao.createExperienciaLaboral(experienciaLaboralACrear);

		return resultado;
	}

	public List<ExperienciaLaboral> readExperienciaLaboral( ) {

		return dao.readExperienciaLaboral();
	}
	
	public List<ExperienciaLaboral> cargarExperiencia( int experienciaAModificar ) {

		return dao.experienciaAModificar( experienciaAModificar );
	}

	public boolean updateExperienciaLaboral( ExperienciaLaboral experienciaLaboralAModificar ) {

		boolean resultado = dao.updateExperienciaLaboral(experienciaLaboralAModificar);

		return resultado;
	}

	public boolean deleteExperienciaLaboral( ExperienciaLaboral experienciaLaboralAEliminar ) {

		boolean resultado = dao.deleteExperienciaLaboral(experienciaLaboralAEliminar);

		return resultado;
	}

}
