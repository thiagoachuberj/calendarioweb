package br.com.calendweb.usuario.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.usuario.facade.Usuario;
import br.com.calendweb.usuario.to.UsuarioTO;

@RequestScoped
@ManagedBean(name="usuarioBean")
public class UsuarioManagedBean {

	@EJB
	private Usuario usuarioFacade;
	private String login;
	private String senha;
	private String nome;
	private String telefone;
	
	
	public String cadastrarUsuario() throws BusinessException {
		
//		FacesContext context = FacesContext.getCurrentInstance();
//		Application application = context.getApplication();
		
		UsuarioTO usuarioTO = new UsuarioTO();
		usuarioTO.setLoginUsuario(login);
		usuarioTO.setNomeUsuario(nome);
		usuarioTO.setSenhaUsuario(senha);
		usuarioTO.setTelefoneUsuario(telefone);
		
		try {
			usuarioFacade.criarUsuario(usuarioTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "sucesso";
	}
	
	public String consultaTodosUsuario() throws BusinessException {
		return "listaUsuarios";
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
