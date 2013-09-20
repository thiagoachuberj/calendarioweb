package br.com.teste.calendweb.usuario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.calendweb.dao.FactoryDAO;
import br.com.calendweb.dao.FactoryDAOImpl;
import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.usuario.dao.GerenciadorUsuarioDAO;
import br.com.calendweb.usuario.facade.UsuarioFacadeBean;
import junit.framework.Assert;
import junit.framework.TestCase;

@RunWith(PowerMockRunner.class)
public class UsuarioFacadeBeanTest extends TestCase {

	UsuarioFacadeBean ufb;
	
	/**
	 * Testa busca de usuario por login.
	 * 
	 * @throws BusinessException
	 */
	@Test
	public void testBuscarUsuarioPorLogin() throws BusinessException {
		ufb = new UsuarioFacadeBean();
		FactoryDAO facDao = Mockito.mock(FactoryDAO.class);
		FactoryDAOImpl fac = Mockito.mock(FactoryDAOImpl.class);
		GerenciadorUsuarioDAO dao = Mockito.mock(GerenciadorUsuarioDAO.class);
		Usuario usuario = Mockito.mock(Usuario.class);
		
		Mockito.when(facDao.getUsuario()).thenReturn(usuario);
//		Mockito.when(fac.getUsuario()).thenReturn(dao);
		LoginTO loginTO = new LoginTO();
		loginTO.setLogin("teste");
		loginTO.setSenha("teste".getBytes());
		loginTO.setSenhaStr("");
		
		Assert.assertNotNull(ufb.buscarUsuarioPorLogin(loginTO));
	}

	@Test
	public void testAtualizaUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testCadastraUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultaTodosUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultaUsuariosByCampos() {
		fail("Not yet implemented");
	}

}
