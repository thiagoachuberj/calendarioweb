package br.com.calendweb.usuario.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.calendweb.dao.FactoryDAO;
import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.usuario.to.UsuarioTO;

/**
 * Classe EJB responsavel por disponibilizar os servicos de usuario.
 * 
 * @author MM
 */
@Stateless
public class UsuarioFacadeBean implements UsuarioLocal {

	@EJB
	private FactoryDAO factoryDAO;
	
	/**
	 * Recupera a instancia do usuarioDAO.
	 * 
	 * @return UsuarioDAO 
	 */
	private Usuario getUsuario() {
		Usuario dao = factoryDAO.getUsuario();
		return dao;
	}
	
	@Override
	public UsuarioTO buscarUsuarioPorLogin(LoginTO loginTO)	throws BusinessException {
		UsuarioTO to = getUsuario().buscarUsuarioPorLogin(loginTO);
		return to;
	}
	
	@Override
	public void atualizaUsuario(UsuarioTO usuarioTO) throws BusinessException {
		getUsuario().atualizaUsuario(usuarioTO);
		
	}

	@Override
	public void cadastraUsuario(UsuarioTO usuarioTO) throws BusinessException {
		getUsuario().cadastraUsuario(usuarioTO);
	}

	@Override
	public void setEntityManager(EntityManager manager) {
//		GerenciadorUsuarioDAO dao = GerenciadorUsuarioDAO.getInstance();
		getUsuario().setEntityManager(manager);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioTO> consultaTodosUsuarios() throws BusinessException {
		return getUsuario().consultaTodosUsuarios();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioTO> consultaUsuariosByCampos(UsuarioTO usuarioTO) throws BusinessException {
		return getUsuario().consultaUsuariosByCampos(usuarioTO);
	}
	
	/**
	 * Metodo standalone para realizacao de testes.
	 * 
	 * @param args 
	 * @throws BusinessException 
	 */
	public static void main(String []args) throws BusinessException {
		EntityManager manager = null;
		EntityManagerFactory factory = null;
		EntityTransaction transaction = null;
		
		factory = Persistence.createEntityManagerFactory("calendWebUnit");
		manager = factory.createEntityManager();
		
		UsuarioFacadeBean facade = new UsuarioFacadeBean();
		facade.setEntityManager(manager);
		
		transaction = manager.getTransaction();
		transaction.begin();
		
		//consultaUsuario por id
//		UsuarioTO to = facade.buscarUsuarioPorLogin("1");
//		
//		System.out.println(to.getLoginUsuario());
//		System.out.println(to.getEmailUsuario());
				
		transaction.commit();
	}

}
