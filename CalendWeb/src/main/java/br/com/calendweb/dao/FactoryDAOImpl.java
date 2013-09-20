package br.com.calendweb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.usuario.dao.GerenciadorUsuarioDAO;

/**
 * Factory responsável por disponibilizar os objetos para acesso via EJB Local.
 * 
 * @author MM
 */
@Stateless
public class FactoryDAOImpl implements FactoryDAO {
	
	@PersistenceContext(unitName = "calendWebUnit")
	private EntityManager manager;

/*	@Override
	public Usuario getUsuario() {
		return new GerenciadorUsuarioDAO();
	}
*/	
	@Override
	public Usuario getUsuario() {
		return new GerenciadorUsuarioDAO(manager);
	}

	/**
	 * @return the manager
	 */
/*	public EntityManager getManager() {
		return manager;
	}

	*//**
	 * @param manager the manager to set
	 *//*
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
*/
}
