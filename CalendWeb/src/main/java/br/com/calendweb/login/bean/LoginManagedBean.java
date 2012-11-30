package br.com.calendweb.login.bean;

import javax.ejb.EJB;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.facade.Usuario;
import br.com.calendweb.usuario.facade.UsuarioFacadeBean;
import br.com.calendweb.util.EncriptaSenha;

/**
 * Classe responsavel por realizar o login.
 * Consulta o servico do {@link UsuarioFacadeBean} para realizar o acesso.
 * @author mek
 */
public class LoginManagedBean {

	/** Recupera uma instancia do Ejb*/
	@EJB
	private Usuario usuarioFacade;
	private String login;
	private String senha;
	
	public String realizaLogin() throws BusinessException {
		LoginTO loginTO = new LoginTO();
		loginTO.setLogin(login);
		loginTO.setSenha(EncriptaSenha.encriptaSenha(senha));
		
		usuarioFacade.buscarUsuarioPorLogin(loginTO);
		return "paginaPrincipal";
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
