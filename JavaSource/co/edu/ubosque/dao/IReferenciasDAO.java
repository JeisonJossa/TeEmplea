package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.Referencias;

public interface IReferenciasDAO {

	public boolean createReferencias( Referencias referenciasACrear );

	public List<Referencias> readReferencias( );
	
	//Metodo que carga la referencia por usuario
	public List<Referencias> cargarReferencias ( int cargarInformacion );

	public boolean updateReferencias( Referencias referenciasAModificar );

	public boolean deleteReferencias( Referencias referenciasAEliminar );
	
}
