package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.TipoDocumento;


public interface ITipoDocumentoDAO {

	public boolean createTipoDocumento( TipoDocumento tipoDocumentoACrear );

	public List<TipoDocumento> readTipoDocumento( );

	public boolean updateTipoDocumento( TipoDocumento tipoDocumentoAModificar );

	public boolean deleteTipoDocumento( TipoDocumento tipoDocumentoAEliminar );

}
