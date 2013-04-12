package br.com.calendweb.usuario.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.usuario.facade.UsuarioLocal;
import br.com.calendweb.usuario.to.UsuarioTO;
import br.com.calendweb.util.Constantes;
import br.com.calendweb.util.EncriptaSenha;

/**
 * Managed Bean responsáveis por ações referente ao Usuaário.
 * 
 * @author MM
 *
 */
@SessionScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioManagedBean implements Serializable, Constantes{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioLocal usuarioFacade;
	private String login;
	private String senha;
	private String nome;
	private String telefone;
	private UsuarioTO usuario;
	private ListDataModel<UsuarioTO> lstDataModelUsuarioTO;
	
	/**
	 * Método responsável por realizar o cadastro de um usuario.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String cadastraUsuario() throws BusinessException {
//		FacesContext context = FacesContext.getCurrentInstance();
//		Application application = context.getApplication();
		
		UsuarioTO usuarioTO = new UsuarioTO();
		usuarioTO.setLoginUsuario(login);
		usuarioTO.setNomeUsuario(nome);
		usuarioTO.setSenhaUsuario(EncriptaSenha.encriptaSenha(senha));
		usuarioTO.setTelefoneUsuario(telefone);
		
		try {
			usuarioFacade.cadastraUsuario(usuarioTO);
			usuario = new UsuarioTO();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return Constantes.SUCESSO;
	}
	
	/**
	 * Método respnsável por buscar todos os usuário.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String consultaTodosUsuario() throws BusinessException {
		List<UsuarioTO> lstUsuarioTO = usuarioFacade.consultaTodosUsuarios();
		
		this.lstDataModelUsuarioTO = new ListDataModel<UsuarioTO>(lstUsuarioTO);
		
		return Constantes.CONSULTA_USUARIOS;
	}
	
	/**
	 * Carrega o usuario.
	 * 
	 * @param usuarioTO
	 */
	public void carregaUsuario(UsuarioTO usuarioTO){
		this.usuario = usuarioTO;
	}
	
	/**
	 * Realiza a pesquisa de usuários com base no preenchimento do formulário.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String editarUsuario() throws BusinessException {
		this.usuario = (UsuarioTO) this.lstDataModelUsuarioTO.getRowData();
		//lstUsuarioTO = usuarioFacade.consultaUsuariosByCampos(usuarioTO);
		
		return Constantes.EDITAR_USUARIO;
	}
	
	/**
	 * Atualiza os dados do usuario.
	 * 
	 * @return String 
	 * @throws BusinessException 
	 */
	public String atualizaUsuarios() throws BusinessException {
		UsuarioTO usuarioTO = new UsuarioTO();
		usuarioTO.setLoginUsuario(login);
		usuarioTO.setNomeUsuario(nome);
		usuarioTO.setTelefoneUsuario(telefone);
		
		usuarioFacade.atualizaUsuario(usuarioTO);
		
	//	lstUsuarioTO = usuarioFacade.consultaTodosUsuarios();
		
		return Constantes.CONSULTA_USUARIOS;
	}
	
	/**
	 * Realiza a exclusão do usuário em questão.
	 * 
	 * @return String 
	 */
	public String deletaUsuario() {
		return Constantes.CONSULTA_USUARIOS;
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

	/**
	 * @return the usuario
	 */
	public UsuarioTO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the lstUsuarioTO
	 */
	public ListDataModel<UsuarioTO> getLstDataModelUsuarioTO() {
		return lstDataModelUsuarioTO;
	}

	/**
	 * @param lstUsuarioTO the lstUsuarioTO to set
	 */
	public void setLstDataModelUsuarioTO(ListDataModel<UsuarioTO> lstDataModelUsuarioTO) {
		this.lstDataModelUsuarioTO = lstDataModelUsuarioTO;
	}

}
