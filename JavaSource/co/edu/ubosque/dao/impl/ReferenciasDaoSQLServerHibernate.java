package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IReferenciasDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.Referencias;



public class ReferenciasDaoSQLServerHibernate implements IReferenciasDAO{

	public  ReferenciasDaoSQLServerHibernate() {
		
	}
	

	@Override
	public boolean createReferencias( Referencias referenciasACrear ) {
		
		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.persist(referenciasACrear);
		session.getTransaction().commit();

		return true;
		
	}
	@Override
	public List<Referencias> readReferencias() {
		
		String hqlr = "select r from Referencias r";
		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		
		try {
			
			Query query = session.createQuery(hqlr);
			List<Referencias> lista = query.getResultList();

			session.getTransaction().commit();
			session.close();

			return lista;
			
		} catch (Exception e) {
			System.out.println(e);
			session.close();
			return null;
		}		
	}
	
	@Override
	public boolean updateReferencias(Referencias referenciasAModificar) {
		
		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(referenciasAModificar);
		session.getTransaction().commit();

		return true;
	}
	
	@Override
	public boolean deleteReferencias(Referencias referenciasAEliminar) {
		
		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(referenciasAEliminar);
		session.getTransaction().commit();

		return true;
	}


	@Override
	public List<Referencias> cargarReferencias(int cargarInformacion) {

		String hql = "select s from Referencias s where s.identificacion = '" + cargarInformacion + "'";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		
		try {
			Query query = session.createQuery(hql);
			List<Referencias> lista = query.list();

			session.getTransaction().commit();
			session.close();
			return lista;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
