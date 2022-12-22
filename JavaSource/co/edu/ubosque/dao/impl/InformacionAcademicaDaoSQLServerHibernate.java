package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IInformacionAcademicaDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.InformacionAcademica;


public class InformacionAcademicaDaoSQLServerHibernate implements IInformacionAcademicaDAO {

	public InformacionAcademicaDaoSQLServerHibernate() {

	}

	@Override
	public boolean createInformacionAcademica( InformacionAcademica informacionAcademicaACrear ) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.persist(informacionAcademicaACrear);
		session.getTransaction().commit();

		return true;

	}
	@Override
	public List<InformacionAcademica> readInformacionAcademica() {

		String hql = "select i from InformacionAcademica i";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		
		try {

			Query query = session.createQuery(hql);
			List<InformacionAcademica> lista = query.getResultList();

			session.getTransaction().commit();
			session.close();

			return lista;
		} catch (Exception e) {
			System.out.println(e);
			session.close();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateInformacionAcademica(InformacionAcademica informacionAcademicaAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(informacionAcademicaAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteInformacionAcademica(InformacionAcademica informacionAcademicaAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(informacionAcademicaAEliminar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public List<InformacionAcademica> cargarInformacionAcademica(int informacionAcademica) {

		String hql = "select s from InformacionAcademica s where s.identificacion = '" + informacionAcademica + "'";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();

		try {
			Query query = session.createQuery(hql);
			List<InformacionAcademica> lista = query.list();

			session.getTransaction().commit();
			session.close();
			return lista;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			session.close();
		}

	}

}
