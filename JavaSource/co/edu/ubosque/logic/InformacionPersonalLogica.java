package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import co.edu.ubosque.dao.IInformacionPersonalDAO;
import co.edu.ubosque.dao.IUsuarioDAO;
import co.edu.ubosque.dao.impl.InformacionPersonalDaoSQLServerHibernate;
import co.edu.ubosque.dao.impl.UsuarioDaoSQLServerHibernate;
import co.edu.ubosque.model.InformacionPersonal;
import co.edu.ubosque.model.TeEmplea;
import co.edu.ubosque.model.Usuario;

public class InformacionPersonalLogica {

	private IInformacionPersonalDAO dao;
	private ResourceBundle rs;

	public InformacionPersonalLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new InformacionPersonalDaoSQLServerHibernate(); 

		} else {

		}

	}

	public boolean CreateInformacionPersonal( InformacionPersonal informacionPersonalACrear ) {

		boolean resultado = dao.createInformacionPersonal(informacionPersonalACrear);

		return resultado;
	}

	public List<InformacionPersonal> readInformacionPersonal( ) {

		return dao.readInformacionPersonal();
	}

	public List<InformacionPersonal> cargarPerfil( String cedulaPersona ) {

		return dao.perfilAModificar(cedulaPersona);
	}

	public boolean updateInformacionPersonal( InformacionPersonal informacionPersonalAModificar ) {

		boolean resultado = dao.updateInformacionPersonal(informacionPersonalAModificar);

		return resultado;
	}

	public boolean deleteInformacionPersonal( InformacionPersonal informacionPersonalAEliminar ) {

		boolean resultado = dao.deleteInformacionPersonal(informacionPersonalAEliminar);

		return resultado;
	}

	public InformacionPersonal validarInformacion( InformacionPersonal validarCedula) {

		return dao.validarDatos(validarCedula);
	}

	public InformacionPersonal validarInformacionCreada( InformacionPersonal validarCedula) {

		return dao.validarPerfilProfesional(validarCedula);
	}

}
