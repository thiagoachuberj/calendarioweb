package br.com.calendweb.usuario.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.usuario.to.UsuarioTO;

/**
 * 
 * @author MM
 *
 */
@RequestScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioManagedBean {

	@EJB
	private Usuario usuarioFacade;
	private String login;
	private String senha;
	private String nome;
	private String telefone;
	
	/**
	 * Método responsável por realizar o cadastro de um usuario.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String cadastrarUsuario() throws BusinessException {
		
//		FacesContext context = FacesContext.getCurrentInstance();
//		Application application = context.getApplication();
		
		UsuarioTO usuarioTO = new UsuarioTO();
		usuarioTO.setLoginUsuario(login);
		usuarioTO.setNomeUsuario(nome);
		usuarioTO.setSenhaUsuario(senha);
		usuarioTO.setTelefoneUsuario(telefone);
		
		try {
			usuarioFacade.cadastraUsuario(usuarioTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "sucesso";
	}
	
	/**
	 * Método respnsável por buscar todos os usuário.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String consultaTodosUsuario() throws BusinessException {
		return "listaUsuarios";
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

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
