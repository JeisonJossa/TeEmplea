package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IOfertaLaboralDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.OfertaLaboral;


public class OfertaLaboralDaoSQLServerHibernate implements IOfertaLaboralDAO {

	public OfertaLaboralDaoSQLServerHibernate() {

	}

	@Override
	public boolean createOfertaLaboral(OfertaLaboral ofertaLaboralACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(ofertaLaboralACrear);
		session.getTransaction().commit();

		return true;

	}

	@Override
	public List<OfertaLaboral> readOfertaLaboral() {

		String hql = "select s from OfertaLaboral s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			List<OfertaLaboral> lista = query.getResultList();

			session.getTransaction().commit();
			session.close();
			return lista;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}		
	}

	@Override
	public boolean updateOfertaLaboral(OfertaLaboral ofertaLaboralAModificar) {
		
		try {
			
			Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
			session.beginTransaction();
			session.merge(ofertaLaboralAModificar);
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			return true;
		}
		
	}

	@Override
	public boolean deleteOfertaLaboral(OfertaLaboral ofertaLaboralAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(ofertaLaboralAEliminar);
		session.getTransaction().commit();

		return true;
	}

}
