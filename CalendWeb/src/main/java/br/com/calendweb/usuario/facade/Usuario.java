package br.com.calendweb.usuario.facade;

import javax.ejb.Local;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.to.UsuarioTO;

@Local
public interface Usuario {

	UsuarioTO buscarUsuarioPorLogin (LoginTO loginTO) throws BusinessException;
	void criarUsuario (UsuarioTO usuarioTO) throws BusinessException;
}
