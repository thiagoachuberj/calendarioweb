package br.com.calendweb.dao;

import javax.persistence.EntityManager;

import br.com.calendweb.to.BaseTO;

public abstract class AbstractDAO {

	protected EntityManager manager;
	
	public abstract Object convertaTOParaEntity (BaseTO objtoTO);
	public abstract BaseTO convertaEntityParaTO (Object entity);
}
