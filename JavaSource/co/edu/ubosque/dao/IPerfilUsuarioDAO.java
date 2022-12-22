package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.PerfilUsuario;

public interface IPerfilUsuarioDAO {
	
	public boolean createPerfilUsuario( PerfilUsuario perfilUsuarioACrear );

	public List<PerfilUsuario> readPerfilUsuario( );

	public boolean updatePerfilUsuario( PerfilUsuario perfilUsuarioAModificar );

	public boolean deletePerfilUsuario( PerfilUsuario perfilUsuarioAEliminar );

}
