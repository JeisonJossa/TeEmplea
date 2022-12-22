package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.EstadoCivil;
import co.edu.ubosque.model.Sector;


public interface IEstadoCivilDAO {

	
	public boolean createEstadoCivil( EstadoCivil EstadoCivilACrear );

	public List<EstadoCivil> readEstadoCivil( );

	public boolean updateEstadoCivil( EstadoCivil EstadoCivilAModificar );

	public boolean deleteEstadoCivil( EstadoCivil EstadoCivilAEliminar );


}
