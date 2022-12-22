package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.Sector;

public interface ISectorDAO {

	public boolean createSector( Sector sectorACrear );

	public List<Sector> readSector( );

	public boolean updateSector( Sector sectorAModificar );

	public boolean deleteSector( Sector sectorAEliminar );

}
