package br.com.calendweb.usuario;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.to.UsuarioTO;

/**
 * Interface do objeto Usuario.
 * 
 * @author MM
 */
public interface Usuario {
	
	/**
	 * Atualiza os dados cadastrais do cliente na base de dados.
	 * 
	 * @param usuarioTO 
	 * @throws BusinessException 
	 */
	void atualizaUsuario(UsuarioTO usuarioTO) throws BusinessException;
	
	/**
	 * Realiza o login do usuario no sistema buscando pelo login e senha.
	 * 
	 * @param loginTO 
	 * @throws BusinessException 
	 * @return UsuarioTO 
	 */
	UsuarioTO buscarUsuarioPorLogin(LoginTO loginTO) throws BusinessException;
	
	/**
	 * Cadastra um usuário na base de dados.
	 * 
	 * @param usuarioTO 
	 * @throws BusinessException 
	 */
	void cadastraUsuario(UsuarioTO usuarioTO) throws BusinessException;
	
	/**
	 * Seta o entity manager para realizacao de testes standalone.
	 * 
	 * @param manager 
	 */
	void setEntityManager(EntityManager manager);
	
	/**
	 * Consulta todos os usuários.
	 * 
	 *  @return List<UsuarioTO>
	 */
	List<UsuarioTO> consultaTodosUsuarios() throws BusinessException;
	
}
