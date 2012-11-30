package br.com.calendweb.usuario.dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.to.UsuarioTO;

@Local
public interface UsuarioDAO {

	UsuarioTO buscarUsuarioPorLogin (LoginTO loginTO) throws BusinessException;
	void criarUsuario (UsuarioTO usuarioTO) throws BusinessException;
	public abstract void setEntityManager(EntityManager manager);
}
