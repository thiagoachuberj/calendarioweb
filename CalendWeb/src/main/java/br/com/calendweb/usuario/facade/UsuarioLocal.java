package br.com.calendweb.usuario.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.usuario.to.UsuarioTO;

/**
 * Interface EJB Local de usuario.
 * 
 * @author MM
 */
@Local
public interface UsuarioLocal extends Usuario {

}
