package br.com.calendweb.usuario.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.calendweb.dao.FactoryDAO;
import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.usuario.dao.UsuarioDAO;
import br.com.calendweb.usuario.to.UsuarioTO;

@Stateless
public class UsuarioFacadeBean implements Usuario {

	@EJB
	private FactoryDAO factoryDAO;
	
	private UsuarioDAO getUsuarioDAO() {
		UsuarioDAO dao = factoryDAO.getUsuarioDAO();
		return dao;
	}
	
	public UsuarioTO buscarUsuarioPorLogin(String loginUsuario)	throws BusinessException {
		UsuarioTO to = getUsuarioDAO().buscarUsuarioPorLogin(loginUsuario);
		return to;
	}

	public void criarUsuario(UsuarioTO usuarioTO) throws BusinessException {
		getUsuarioDAO().criarUsuario(usuarioTO);
	}
	
	public void setEntityManager(EntityManager manager) {
//		GerenciadorUsuarioDAO dao = GerenciadorUsuarioDAO.getInstance();
		getUsuarioDAO().setEntityManager(manager);
	}
	
	public static void main (String []args) throws BusinessException {
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
		UsuarioTO to = facade.buscarUsuarioPorLogin("1");
		
		System.out.println(to.getLoginUsuario());
		System.out.println(to.getEmailUsuario());
		
		
		
		transaction.commit();
	}

}
