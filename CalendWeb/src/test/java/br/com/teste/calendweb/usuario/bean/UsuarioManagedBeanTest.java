package br.com.teste.calendweb.usuario.bean;

import static org.junit.Assert.fail;

import javax.faces.model.ListDataModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.usuario.bean.UsuarioManagedBean;
import br.com.calendweb.usuario.to.UsuarioTO;
import br.com.calendweb.util.EncriptaSenha;

@RunWith( PowerMockRunner.class)
@PrepareForTest({ EncriptaSenha.class })
public class UsuarioManagedBeanTest {

	private UsuarioManagedBean bean;
	
	@Before
	public void iniciar() {
		bean = new UsuarioManagedBean();
		ListDataModel<UsuarioTO> lstDataModel = Mockito.mock(ListDataModel.class);
		bean.setLstDataModelUsuarioTO(lstDataModel);
	}
	
	@Test
	public void testCadastraUsuario() throws BusinessException {
		UsuarioTO usuarioTO = new UsuarioTO();
		usuarioTO.setLoginUsuario("teste");
		usuarioTO.setNomeUsuario("testeNome");
		usuarioTO.setSenhaUsuario("".getBytes());
		usuarioTO.setTelefoneUsuario("");
		
		PowerMockito.mockStatic(EncriptaSenha.class);
		
		Mockito.when(EncriptaSenha.encriptaSenha("")).thenReturn("teste".getBytes());
		
		bean.cadastraUsuario();
	}

	@Test
	public void testConsultaTodosUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testCarregaUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizaUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaUsuario() {
		fail("Not yet implemented");
	}

}
