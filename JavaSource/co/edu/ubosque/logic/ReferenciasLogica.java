package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Entity;
import javax.swing.JOptionPane;

import co.edu.ubosque.dao.IReferenciasDAO;
import co.edu.ubosque.dao.impl.ReferenciasDaoSQLServerHibernate;
import co.edu.ubosque.model.Referencias;

@Entity
public class ReferenciasLogica {
	
	private IReferenciasDAO dao;
	private ResourceBundle rs;

	public ReferenciasLogica() {
		
		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new ReferenciasDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}
	}

	public boolean createReferencias( Referencias referenciaACrear ) {

		boolean resultado = dao.createReferencias(referenciaACrear);

		return resultado;
	}

	public List<Referencias> readReferencias( ) {

		return dao.readReferencias();
	}
	
	public List<Referencias> cargarReferencias( int cargarReferencias ) {
		
		return dao.cargarReferencias(cargarReferencias);
	}

	public boolean updateReferencias( Referencias referenciaAModificar ) {

		boolean resultado = dao.updateReferencias(referenciaAModificar);

		return resultado;
	}

	public boolean deleteReferencias( Referencias referenciasAEliminar ) {

		boolean resultado = dao.deleteReferencias(referenciasAEliminar);

		return resultado;
	}

}
