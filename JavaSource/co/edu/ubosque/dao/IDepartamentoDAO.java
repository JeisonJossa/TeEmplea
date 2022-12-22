package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.Departamento;
import co.edu.ubosque.model.Sector;


public interface IDepartamentoDAO {

	

	public boolean createDepartamento( Departamento DepartamentoACrear );

	public List<Departamento> readDepartamento( );

	public boolean updateDepartamento( Departamento DepartamentoAModificar );

	public boolean deleteDepartamento( Departamento DepartamentoAEliminar );

	

}
