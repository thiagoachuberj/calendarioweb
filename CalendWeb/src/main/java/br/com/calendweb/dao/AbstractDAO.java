package br.com.calendweb.dao;

import br.com.calendweb.to.BaseTO;

/**
 * Classe abstrata base para todos os DAOs.
 * 
 * @author MM
 */
public interface AbstractDAO {

	/**
	 * Converte o objeto TO em um objeto Entity.
	 * 
	 * @param objetoTO 
	 * @return Object  
	 */
	public abstract Object convertaTOParaEntity(BaseTO Object);
	
	/**
	 * Converte o objeto Entity em um objeto TO.
	 * 
	 * @param entity 
	 * @return BaseTO 
	 */
	public abstract BaseTO convertaEntityParaTO(Object obj);

}
