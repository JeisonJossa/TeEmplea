package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.ubosque.dao.IDepartamentoDAO;

import co.edu.ubosque.dao.impl.DepartamentoDaoSQLServerHibernate;

import co.edu.ubosque.model.Departamento;
 


public class DepartamentoLogica {

	private IDepartamentoDAO dao;
	private ResourceBundle rs;

	public DepartamentoLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new DepartamentoDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}
	
	public boolean CreateDepartamento( Departamento departamentoACrear ) {

		boolean resultado = dao.createDepartamento( departamentoACrear );

		return resultado;
	}
	
	public List<Departamento> readDepartamento( ) {

		return dao.readDepartamento();
	}
	
	public boolean updateDepartamento( Departamento departamentoAModificar ) {

		boolean resultado = dao.updateDepartamento(departamentoAModificar);

		return resultado;
	}

	public boolean deleteDepartamento( Departamento departamentoAEliminar ) {

		boolean resultado = dao.deleteDepartamento(departamentoAEliminar);

		return resultado;
	}


}
