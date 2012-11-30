package br.com.calendweb.login.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.util.EncriptaSenha;

/**
 * Classe responsavel por realizar o login.
 * Consulta o servico do {@link UsuarioFacadeBean} para realizar o acesso.
 * 
 * @author mek
 */
@RequestScoped
@ManagedBean(name = "loginBean")
public class LoginManagedBean {

	/** Recupera uma instancia do EJB. */
	@EJB
	private Usuario usuarioFacade;
	private String login;
	private String senha;
	
	/**
	 * Método responsável por realizar o login.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String realizaLogin() throws BusinessException {
		LoginTO loginTO = new LoginTO();
		loginTO.setLogin(login);
		loginTO.setSenha(EncriptaSenha.encriptaSenha(senha));
		
		usuarioFacade.buscarUsuarioPorLogin(loginTO);
		return "paginaPrincipal";
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
	
}
