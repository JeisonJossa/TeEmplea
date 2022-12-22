package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.ISectorDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.Sector;

public class SectorDaoSQLServerHibernate implements ISectorDAO {

	public SectorDaoSQLServerHibernate() {
		
	}
	
	@Override
	public boolean createSector(Sector sectorACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(sectorACrear);
		session.getTransaction().commit();

		return true;

	}

	@Override
	public List<Sector> readSector() {

		String hql = "select s from Sector s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(hql);
		List<Sector> lista = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return lista;
	}

	@Override
	public boolean updateSector(Sector sectorAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(sectorAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteSector(Sector sectorAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(sectorAEliminar);
		session.getTransaction().commit();

		return true;
	}

}
