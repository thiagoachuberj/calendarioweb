package br.com.calendweb.login.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.bean.UsuarioManagedBean;
import br.com.calendweb.usuario.facade.UsuarioFacadeBean;
import br.com.calendweb.usuario.facade.UsuarioLocal;
import br.com.calendweb.usuario.to.UsuarioTO;
import br.com.calendweb.util.Constantes;
import br.com.calendweb.util.EncriptaSenha;

/**
 * Classe responsavel por realizar o login.
 * Consulta o servico do {@link UsuarioFacadeBean} para realizar o acesso.
 * 
 * @author mek
 */
@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginManagedBean implements Serializable, Constantes {

	private static final long serialVersionUID = 1L;
	
	/** Recupera uma instancia do EJB. */
	@EJB
	private UsuarioLocal usuarioFacade;
	private String login;
	private String senha;
	
	@Inject
	private UsuarioManagedBean usuarioBean;
	private FacesContext faceContext;
	
	public LoginManagedBean() {
		
	}
	
	/**
	 * Método responsável por realizar o login.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String realizaLogin() throws BusinessException {
		faceContext = FacesContext.getCurrentInstance();
		LoginTO loginTO = new LoginTO();
		loginTO.setLogin(login);
		loginTO.setSenha(EncriptaSenha.encriptaSenha(senha));
		
		UsuarioTO usuarioTO = usuarioFacade.buscarUsuarioPorLogin(loginTO);
		String navigationCase = Constantes.CONSULTA_USUARIOS;
		
		if (usuarioTO != null) {
			usuarioBean.setUsuario(usuarioTO);
			usuarioBean.consultaTodosUsuario();
		} else {
			FacesMessage faceMessage  = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não Encontrado.", null);
			faceContext.addMessage(null, faceMessage);
			navigationCase = Constantes.HOME;
		}
		
		return navigationCase;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioManagedBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioManagedBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
	
	
	
}
