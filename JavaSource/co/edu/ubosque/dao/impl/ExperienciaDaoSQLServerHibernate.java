package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IExperienciaLaboralDAO;
import co.edu.ubosque.dao.ISectorDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.ExperienciaLaboral;
import co.edu.ubosque.model.Sector;
import co.edu.ubosque.model.Usuario;

public class ExperienciaDaoSQLServerHibernate implements IExperienciaLaboralDAO {

	public ExperienciaDaoSQLServerHibernate() {

	}
	@Override
	public boolean createExperienciaLaboral(ExperienciaLaboral experienciaLaboralACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.persist(experienciaLaboralACrear);
		session.getTransaction().commit();

		return true;

	}

	@Override
	public List<ExperienciaLaboral> readExperienciaLaboral() {

		String hql = "select s from ExperienciaLaboral s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		
		try {
			
			Query query = session.createQuery(hql);
			List<ExperienciaLaboral> lista = query.getResultList();

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
	public boolean updateExperienciaLaboral(ExperienciaLaboral experienciaLaboralAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(experienciaLaboralAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteExperienciaLaboral(ExperienciaLaboral experienciaLaboralAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(experienciaLaboralAEliminar);
		session.getTransaction().commit();

		return true;
	}
	@Override
	public List<ExperienciaLaboral> experienciaAModificar( int experienciaAModificar ) {


		String hql = "select s from ExperienciaLaboral s where s.identificacion = '" + experienciaAModificar + "'";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		
		try {
			Query query = session.createQuery(hql);
			List<ExperienciaLaboral> lista = query.list();

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
