package br.com.calendweb.dao;

import javax.persistence.EntityManager;

import br.com.calendweb.to.BaseTO;

/**
 * Classe abstrata base para todos os DAOs.
 * 
 * @author MM
 */
public abstract class AbstractDAO {

	private EntityManager manager;
	
	/**
	 * Converte o objeto TO em um objeto Entity.
	 * 
	 * @param objetoTO 
	 * @return Object  
	 */
	public abstract Object convertaTOParaEntity(BaseTO objetoTO);
	
	/**
	 * Converte o objeto Entity em um objeto TO.
	 * 
	 * @param entity 
	 * @return BaseTO 
	 */
	public abstract BaseTO convertaEntityParaTO(Object entity);
	
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
