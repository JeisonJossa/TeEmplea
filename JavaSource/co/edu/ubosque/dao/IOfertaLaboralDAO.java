package co.edu.ubosque.dao;

import java.util.List;

import co.edu.ubosque.model.OfertaLaboral;

public interface IOfertaLaboralDAO {
	
	public boolean createOfertaLaboral( OfertaLaboral ofertaLaboralACrear );

	public List<OfertaLaboral> readOfertaLaboral( );

	public boolean updateOfertaLaboral( OfertaLaboral ofertaLaboralAModificar );

	public boolean deleteOfertaLaboral( OfertaLaboral ofertaLaboralAEliminar );

}
