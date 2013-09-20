/**
 * 
 */
package br.com.calendweb.dao;

import javax.persistence.EntityManager;

/**
 * @author mek
 *
 */
public abstract class JPAAbstractDAO implements AbstractDAO {

	private EntityManager manager;
	
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
