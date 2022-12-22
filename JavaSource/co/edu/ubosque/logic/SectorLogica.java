package co.edu.ubosque.logic;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.ubosque.dao.ISectorDAO;
import co.edu.ubosque.dao.impl.SectorDaoSQLServerHibernate;
import co.edu.ubosque.model.EstadoCivil;
import co.edu.ubosque.model.Sector;
import co.edu.ubosque.model.Usuario;


public class SectorLogica {

	private ISectorDAO dao;
	private ResourceBundle rs;

	public SectorLogica() {

		rs = ResourceBundle.getBundle("config");
		String conexionBD = rs.getString("conexionBD");

		if ( conexionBD != null && conexionBD.equals( "3" )) {
			dao = new SectorDaoSQLServerHibernate(); 

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se pudo establecer conexion con la DB");
		}

	}

	public boolean CreateSector( Sector sectorACrear ) {

		boolean resultado = dao.createSector( sectorACrear );

		return resultado;
	}

	public List<Sector> readSector( ) {

		return dao.readSector();
	}

	public boolean updateSector( Sector sectorAModificar ) {

		boolean resultado = dao.updateSector(sectorAModificar);

		return resultado;
	}

	public boolean deleteSector( Sector sectorAEliminar ) {

		boolean resultado = dao.deleteSector(sectorAEliminar);

		return resultado;
	}

}
