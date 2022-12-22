package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.InformacionAcademica;

public interface IInformacionAcademicaDAO {
	
	public boolean createInformacionAcademica( InformacionAcademica informacionAcademicaaACrear );

	public List<InformacionAcademica> readInformacionAcademica( );

	public boolean updateInformacionAcademica( InformacionAcademica informacionAcademicaAModificar );

	public boolean deleteInformacionAcademica( InformacionAcademica informacionAcademicaAEliminar );
	
	//Metodo que carga la informacion academica por usuario
	public List<InformacionAcademica> cargarInformacionAcademica( int informacionAcademica );

}
