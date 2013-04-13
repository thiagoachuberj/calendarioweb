package br.com.calendweb.dao;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.calendweb.to.BaseTO;

/**
 * Classe abstrata base para todos os DAOs.
 * 
 * @author MM
 */
public abstract class AbstractDAO<T> {

	private EntityManager manager;
	private static SessionFactory sessionFactory;
	
	/**
	 * Converte o objeto TO em um objeto Entity.
	 * 
	 * @param objetoTO 
	 * @return Object  
	 */
	public abstract Object convertaTOParaEntity(T Object);
	
	/**
	 * Converte o objeto Entity em um objeto TO.
	 * 
	 * @param entity 
	 * @return BaseTO 
	 */
	public abstract BaseTO convertaEntityParaTO(Object obj);
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				sessionFactory = cfg.buildSessionFactory();
			} catch (Throwable e) {
				System.out.println(e);
			}
			return sessionFactory;			
		} else {
			return sessionFactory;
		}
	}
	
	/**
	 * @return the manager
	 */
	public EntityManager getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
