/**
 * 
 */
package br.com.calendweb.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import br.com.calendweb.evento.entity.EventoEntity;
import br.com.calendweb.usuario.entity.UsuarioEntity;

/**
 * @author mek
 *
 */
public abstract class HibernateAbstractDAO implements AbstractDAO {

	private static SessionFactory sessionFactory;
		
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				AnnotationConfiguration ac = new AnnotationConfiguration();
				ac.addAnnotatedClass(UsuarioEntity.class);
				ac.addAnnotatedClass(EventoEntity.class);
				sessionFactory = ac.configure().buildSessionFactory();
			} catch (Throwable e) {
				System.out.println(e);
			}
			return sessionFactory;			
		} else {
			return sessionFactory;
		}
	}

}
