package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.Usuario;

public interface IExperienciaLaboralDAO {
	
	public boolean createExperienciaLaboral( ExperienciaLaboral experienciaLaboralACrear );

	public List<ExperienciaLaboral> readExperienciaLaboral( );
	
	public boolean updateExperienciaLaboral( ExperienciaLaboral experienciaLaboralAModificar );

	public boolean deleteExperienciaLaboral( ExperienciaLaboral experienciaLaboralAEliminar );
	
	//Metodo que va a cargar la informacion unica por usuario
	public List<ExperienciaLaboral> experienciaAModificar(  int experienciaAModificar );

}
