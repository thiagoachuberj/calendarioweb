package br.com.calendweb.dao;

import br.com.calendweb.usuario.Usuario;

/**
 * Interface responsavel por criar uma fabrica de objetos.
 * 
 * @author MM
 */
public interface FactoryDAO {
	
	/**
	 * Cria uma instancia do UsuarioDAO.
	 * 
	 * @return UsuarioDAO 
	 */
	Usuario getUsuario();

}
