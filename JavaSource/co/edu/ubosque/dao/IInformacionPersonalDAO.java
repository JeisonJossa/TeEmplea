package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.InformacionPersonal;
import co.edu.ubosque.model.Usuario;


public interface IInformacionPersonalDAO {

	public boolean createInformacionPersonal( InformacionPersonal informacionPersonalACrear );

	public List<InformacionPersonal> readInformacionPersonal( );
	
	public boolean updateInformacionPersonal( InformacionPersonal informacionPersonalAModificar );

	public boolean deleteInformacionPersonal( InformacionPersonal informacionPersonalAEliminar );
	
	public InformacionPersonal validarDatos( InformacionPersonal usuarioCedula );
	
	public InformacionPersonal validarPerfilProfesional( InformacionPersonal validarCedula );
	
	public List<InformacionPersonal> perfilAModificar( String perfilAModificar );

}
