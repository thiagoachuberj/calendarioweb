package br.com.calendweb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.calendweb.usuario.dao.GerenciadorUsuarioDAO;
import br.com.calendweb.usuario.dao.UsuarioDAO;

@Stateless
public class FactoryDAOImpl implements FactoryDAO {
	
	@PersistenceContext(unitName="calendWebUnit")
	protected EntityManager manager;
	
	public UsuarioDAO getUsuarioDAO() {
		return new GerenciadorUsuarioDAO(manager);
	}

}
