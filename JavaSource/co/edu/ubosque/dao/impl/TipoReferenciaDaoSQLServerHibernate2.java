package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.ITipoReferenciaDAO;
import co.edu.ubosque.dao.IUsuarioDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.TipoReferencia;
import co.edu.ubosque.model.Usuario;

public class TipoReferenciaDaoSQLServerHibernate2 implements ITipoReferenciaDAO {

	public TipoReferenciaDaoSQLServerHibernate2() {

	}

	@Override
	public List<TipoReferencia> readTipoReferencia() {
		 
		String hql = "select s from TipoReferencia s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Query query = session.createQuery(hql);
			List<TipoReferencia> lista = query.getResultList();

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
