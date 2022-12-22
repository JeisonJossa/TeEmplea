package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IEstadoCivilDAO;

import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.EstadoCivil;



public class EstadoCivilDaoSQLServerHibernate implements IEstadoCivilDAO {

	public EstadoCivilDaoSQLServerHibernate() {
		
	}
	
	@Override
	public boolean createEstadoCivil(EstadoCivil estadoCivilACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(estadoCivilACrear);
		session.getTransaction().commit();

		return true;

	}

	@Override
	public List<EstadoCivil> readEstadoCivil() {

		String hql = "select s from EstadoCivil s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(hql);
		List<EstadoCivil> lista = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return lista;
	}

	@Override
	public boolean updateEstadoCivil(EstadoCivil estadoCivilAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(estadoCivilAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteEstadoCivil(EstadoCivil estadoCivilAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(estadoCivilAEliminar);
		session.getTransaction().commit();

		return true;
	}

}
