package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IDepartamentoDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.Departamento;



public class DepartamentoDaoSQLServerHibernate implements IDepartamentoDAO {

	public DepartamentoDaoSQLServerHibernate() {
		
	}
	@Override
	public boolean createDepartamento(Departamento departamentoACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(departamentoACrear);
		session.getTransaction().commit();

		return true;

	}

	@Override
	public List<Departamento> readDepartamento() {

		String hql = "select d from Departamento d";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(hql);
		List<Departamento> lista = query.getResultList();

		session.getTransaction().commit();
		session.close();

		return lista;
	}

	@Override
	public boolean updateDepartamento(Departamento departamentoAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(departamentoAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteDepartamento(Departamento departamentoAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(departamentoAEliminar);
		session.getTransaction().commit();

		return true;
	}

}
