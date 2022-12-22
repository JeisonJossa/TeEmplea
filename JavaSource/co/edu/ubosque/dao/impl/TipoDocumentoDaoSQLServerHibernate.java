package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.ITipoDocumentoDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.TipoDocumento;

public class TipoDocumentoDaoSQLServerHibernate  implements ITipoDocumentoDAO {

		public TipoDocumentoDaoSQLServerHibernate() {

		}
		
		@Override
		public boolean createTipoDocumento(TipoDocumento tipoDocumentoACrear) {

			Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

			session.beginTransaction();
			session.persist(tipoDocumentoACrear);
			session.getTransaction().commit();

			return true;

		}

		@Override
		public List<TipoDocumento> readTipoDocumento() {
			
			String hql = "select s from TipoDocumento s";

			Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

			session.beginTransaction();
			
			try {
				
				Query query = session.createQuery(hql);
				List<TipoDocumento> lista = query.getResultList();

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
		public boolean updateTipoDocumento(TipoDocumento tipoDocumentoAModificar) {

			Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

			session.beginTransaction();
			session.merge(tipoDocumentoAModificar);
			session.getTransaction().commit();

			return true;
		}

		@Override
		public boolean deleteTipoDocumento(TipoDocumento tipoDocumentoAEliminar) {

			Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

			session.beginTransaction();
			session.remove(tipoDocumentoAEliminar);
			session.getTransaction().commit();

			return true;
		}

	}
