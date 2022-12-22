package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;


import co.edu.ubosque.dao.IUsuarioDAO;
import co.edu.ubosque.dao.impl.UsuarioDaoSQLServerHibernate;
import co.edu.ubosque.model.TeEmplea;
import co.edu.ubosque.model.Usuario;

public class UsuarioLogica {

	private IUsuarioDAO dao;
	private ResourceBundle rs;

	public UsuarioLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new UsuarioDaoSQLServerHibernate(); 

		} else {
			
		}

	}

	public boolean CreateUsuario( Usuario usuarioACrear ) {

		boolean resultado = dao.createUsuario(usuarioACrear);
		
		return resultado;
	}

	public List<Usuario> readUsuario( ) {

		return dao.readUsuario();
	}
	
	public Usuario readLogin( Usuario validarLogin ) {
		
		return dao.validarLogin(validarLogin);
	}
	
	public Usuario validarDatos( Usuario validarDatos ) {
	
		return dao.validarDatos(validarDatos);
	}
 
	public boolean updateUsuario( Usuario usuarioAModificar ) {

		boolean resultado = dao.updateUsuario(usuarioAModificar);

		return resultado;
	}

	public boolean deleteUsuario( Usuario usuarioAEliminar ) {

		boolean resultado = dao.deleteUsuario(usuarioAEliminar);

		return resultado;
	}
	
	
}
