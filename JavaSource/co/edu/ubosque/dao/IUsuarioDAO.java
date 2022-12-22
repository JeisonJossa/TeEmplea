package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.Usuario;

/**
 * Interfaz con los metodos para validar registro y login de usuario
 * @author cmoreraz
 *
 */
public interface IUsuarioDAO {

	public boolean createUsuario( Usuario usuarioACrear );

	public List<Usuario> readUsuario( );
	
	public Usuario validarLogin( Usuario validarLogin );
	
	public Usuario validarDatos( Usuario validarDatos );
	
	public boolean updateUsuario( Usuario usuarioAModificar );

	public boolean deleteUsuario( Usuario usuarioAEliminar );

}
