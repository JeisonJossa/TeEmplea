package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.ubosque.dao.IEmpresaDAO;
import co.edu.ubosque.dao.impl.EmpresaDaoSQLServerHibernate;
import co.edu.ubosque.model.Empresa;
import co.edu.ubosque.model.InformacionPersonal;

public class EmpresaLogica {
	
	private IEmpresaDAO dao;
	private ResourceBundle rs;

	public EmpresaLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new EmpresaDaoSQLServerHibernate();

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean CreateEmpresa( Empresa empresaACrear ) {

		boolean resultado = dao.createEmpresa( empresaACrear );

		return resultado;
	}

	public List<Empresa> readEmpresa( ) {

		return dao.readEmpresa();
	}
	
	public List<Empresa> cargarPerfil( long rutEmpresa ){
		 return dao.empresaAModificar(rutEmpresa);
	}

	public boolean updateEmpresa( Empresa empresaAModificar ) {

		boolean resultado = dao.updateEmpresa(empresaAModificar);

		return resultado;
	}

	public boolean deleteEmpresa( Empresa empresaAEliminar ) {

		boolean resultado = dao.deleteEmpresa(empresaAEliminar);

		return resultado;
	}
	
	public Empresa validarInformacion( Empresa validarCedula) {

		return dao.validarDatos(validarCedula);
	}

	public Empresa validarInformacionCreada( Empresa validarCedula) {

		return dao.validarEmpresa(validarCedula);
	}

}
