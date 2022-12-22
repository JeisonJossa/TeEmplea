package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IInformacionPersonalDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.InformacionPersonal;
import co.edu.ubosque.model.Usuario;

public class InformacionPersonalDaoSQLServerHibernate implements IInformacionPersonalDAO {

	public InformacionPersonalDaoSQLServerHibernate() {

	}

	@Override
	public boolean createInformacionPersonal(InformacionPersonal informacionPersonalACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(informacionPersonalACrear);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public List<InformacionPersonal> readInformacionPersonal() {

		String hql = "select s from InformacionPersonal s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			List<InformacionPersonal> lista = query.getResultList();

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
	public boolean updateInformacionPersonal(InformacionPersonal informacionPersonalAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(informacionPersonalAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteInformacionPersonal(InformacionPersonal informacionPersonalAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(informacionPersonalAEliminar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public InformacionPersonal validarDatos(InformacionPersonal usuarioCedula) {

		String hql = "select s from InformacionPersonal s where s.identificacion = '" + usuarioCedula.getIdentificacion() 
		+ " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			InformacionPersonal informacionPersonal = (InformacionPersonal) query.getSingleResult();

			session.getTransaction().commit();
			session.close();

			return informacionPersonal;

		} catch (Exception e) {
			System.out.println(e);
			session.close();
			return null;
		}
	}

	@Override
	public InformacionPersonal validarPerfilProfesional(InformacionPersonal validarCedula) {

		String hql = "select s from InformacionPersonal s where s.identificacion = '" + validarCedula.getIdentificacion() 
		+ "' AND s.correo = '" + validarCedula.getCorreo() + " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			InformacionPersonal informacionPersonal = (InformacionPersonal) query.getSingleResult();

			session.getTransaction().commit();
			session.close();

			return informacionPersonal;

		} catch ( Exception e ) {
			session.close();
			System.out.println(e);			
			return null;
		}	
	}

	@Override
	public List<InformacionPersonal> perfilAModificar(String perfilAModificar) {

		String hql = "select s from InformacionPersonal s where s.identificacion = '" + perfilAModificar 
		+ " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			List<InformacionPersonal> lista = query.getResultList();

			session.getTransaction().commit();
			session.close();
			
			return lista;

		} catch (Exception e) {
			System.out.println(e);
			session.close();
			return null;
		}	
	}

}
