package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IEmpresaDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.Empresa;
import co.edu.ubosque.model.InformacionPersonal;

public class EmpresaDaoSQLServerHibernate implements IEmpresaDAO {

	public EmpresaDaoSQLServerHibernate() {

	}

	@Override
	public boolean createEmpresa( Empresa empresaACrear ) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.persist(empresaACrear);
		session.getTransaction().commit();

		return true;

	}
	@Override
	public List<Empresa> readEmpresa() {
		
		String hql = "select e from Empresa e";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		
		try {
			
			Query query = session.createQuery(hql);
			List<Empresa> lista = query.getResultList();

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
	public boolean updateEmpresa(Empresa empresaAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(empresaAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteEmpresa(Empresa empresaAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(empresaAEliminar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public Empresa validarDatos(Empresa validarDatos) {

		String hql = "select s from Empresa s where s.rut = '" + validarDatos.getRut() 
		+ " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			Empresa informacionEmpresa = (Empresa) query.getSingleResult();

			session.getTransaction().commit();
			session.close();
			return informacionEmpresa;

		} catch (Exception e) {
			System.out.println(e);
			session.close();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public Empresa validarEmpresa(Empresa validarRut) {

		String hql = "select s from Empresa s where s.rut = '" + validarRut.getRut() 
		+ "' AND s.correo = '" + validarRut.getCorreo() + " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		try {

			Query query = session.createQuery(hql);
			Empresa informacionEmpresa = (Empresa) query.getSingleResult();

			session.getTransaction().commit();
			session.close();

			return informacionEmpresa;

		} catch (Exception e) {
			System.out.println(e);
			session.close();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Empresa> empresaAModificar(long perfilAModificar) {

		String hql = "select s from Empresa s where s.rut = '" + perfilAModificar 
				+ " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try {
			
			Query query = session.createQuery(hql);
			List<Empresa> lista = query.getResultList();

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

}
