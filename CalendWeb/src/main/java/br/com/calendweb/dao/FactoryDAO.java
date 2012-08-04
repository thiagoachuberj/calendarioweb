package br.com.calendweb.dao;

import br.com.calendweb.usuario.dao.UsuarioDAO;

public interface FactoryDAO {
	
	UsuarioDAO getUsuarioDAO();

}
