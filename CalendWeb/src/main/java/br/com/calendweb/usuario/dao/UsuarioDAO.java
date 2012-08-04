package br.com.calendweb.usuario.dao;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.usuario.to.UsuarioTO;

@Local
public interface UsuarioDAO {

	UsuarioTO buscarUsuarioPorLogin (String loginUsuario) throws BusinessException;
	void criarUsuario (UsuarioTO usuarioTO) throws BusinessException;
	public abstract void setEntityManager(EntityManager manager);
}
