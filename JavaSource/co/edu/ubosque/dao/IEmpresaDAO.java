package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.Empresa;

/**
 * 
 * @author cmoreraz
 *
 */

public interface IEmpresaDAO {
	
	public boolean createEmpresa( Empresa empresaACrear );

	public List<Empresa> readEmpresa( );

	public boolean updateEmpresa( Empresa empresaAModificar );

	public boolean deleteEmpresa( Empresa empresaAEliminar );
	
	public Empresa validarDatos( Empresa validarDatos );
	
	public Empresa validarEmpresa( Empresa validarRut );
	
	public List<Empresa> empresaAModificar( long perfilAModificar );

}
