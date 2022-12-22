package co.edu.ubosque.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import co.edu.ubosque.dao.IUsuarioDAO;
import co.edu.ubosque.db.ConexionSQLServerHibernate;
import co.edu.ubosque.model.Usuario;

public class UsuarioDaoSQLServerHibernate implements IUsuarioDAO {

	public UsuarioDaoSQLServerHibernate() {

	}

	@Override
	public boolean createUsuario(Usuario usuarioACrear) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		session.persist(usuarioACrear);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public List<Usuario> readUsuario() {

		String hql = "select s from Usuario s";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
				
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			List<Usuario> lista = query.getResultList();

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
	public boolean updateUsuario(Usuario usuarioAModificar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.merge(usuarioAModificar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public boolean deleteUsuario(Usuario usuarioAEliminar) {

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();

		session.beginTransaction();
		session.remove(usuarioAEliminar);
		session.getTransaction().commit();

		return true;
	}

	@Override
	public Usuario validarLogin( Usuario validarLogin ) {
		
		String hql = "select s from Usuario s where s.identificacion = '" + validarLogin.getIdentificacion() 
		+ "' AND s.contrasena = '" + validarLogin.getContrasena() + " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {

			Query query = session.createQuery(hql);
			Usuario usuario = (Usuario) query.getSingleResult();

			session.getTransaction().commit();
			session.close();			
			return usuario;
			
		} catch ( Exception e ) {			
			System.out.println(e);	
			session.close();
			return null;
		} finally {
			session.close();
		}		
				
	}

	@Override
	public Usuario validarDatos(Usuario validarDatos) {

		String hql = "select s from Usuario s where s.identificacion = '" + validarDatos.getIdentificacion() 
		+ "' AND s.correo = '" + validarDatos.getCorreo() + " ' ";

		Session session = ConexionSQLServerHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		
		try {			

			Query query = session.createQuery(hql);
			Usuario usuario = (Usuario) query.getSingleResult();

			session.getTransaction().commit();
			session.close();			
			return usuario;
			
		} catch (Exception e) {			
			System.out.println(e);	
			session.close();
			return null;
		} finally {
			session.close();
		}
	}

}
