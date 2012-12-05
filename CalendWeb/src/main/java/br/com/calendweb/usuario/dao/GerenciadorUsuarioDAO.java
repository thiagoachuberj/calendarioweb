package br.com.calendweb.usuario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.calendweb.dao.AbstractDAO;
import br.com.calendweb.evento.entity.EventoEntity;
import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.login.to.LoginTO;
import br.com.calendweb.to.BaseTO;
import br.com.calendweb.usuario.Usuario;
import br.com.calendweb.usuario.entity.UsuarioEntity;
import br.com.calendweb.usuario.to.UsuarioTO;

/**
 * Classe respons�vel po gerenciar todas as fun��es relacionadas ao usu�rio.
 * 
 * @author MM
 */
public class GerenciadorUsuarioDAO extends AbstractDAO implements Usuario {

	/**
	 * Construtor.
	 * @param manager 
	 */
	public GerenciadorUsuarioDAO(EntityManager manager) {
		this.setManager(manager);
	}
	
	@Override
	public UsuarioTO buscarUsuarioPorLogin(LoginTO loginTO)	throws BusinessException {
		UsuarioTO to = null;
		
		try {
			Query query = getManager().createNamedQuery("consultaUsuario");
			query.setParameter("login", loginTO.getLogin());
			query.setParameter("senha", loginTO.getSenha());
			
			UsuarioEntity entity = (UsuarioEntity) query.getSingleResult();
			to = (UsuarioTO) convertaEntityParaTO(entity);
		} catch (NoResultException ex) {
			return null;
		}

		return to;
	}

	@Override
	public void cadastraUsuario(UsuarioTO usuarioTO) throws BusinessException {
		UsuarioEntity entity = (UsuarioEntity) convertaTOParaEntity(usuarioTO);
		getManager().persist(entity);
	}

	@Override
	public void atualizaUsuario(UsuarioTO usuarioTO) throws BusinessException {
		UsuarioEntity entity = (UsuarioEntity) convertaTOParaEntity(usuarioTO);
		getManager().merge(entity);
	}
	
	@Override
	public Object convertaTOParaEntity(BaseTO to) {
		UsuarioEntity entity = new UsuarioEntity();
		UsuarioTO usuarioTO = (UsuarioTO) to;
		
		entity.setEmailUsuario(usuarioTO.getEmailUsuario());
		entity.setIdUsuario(usuarioTO.getIdUsuario());
		entity.setLoginUsuario(usuarioTO.getLoginUsuario());
		entity.setNomeUsuario(usuarioTO.getNomeUsuario());
		entity.setSenhaUsuario(usuarioTO.getSenhaUsuario());
		entity.setTelefoneUsuario(usuarioTO.getTelefoneUsuario());
		
		List<EventoEntity> lstEvento = new ArrayList<EventoEntity>();
/*		for (EventoTO eventoTO : usuarioTO.getEventos()) {
			EventoEntity eventoEntity = new EventoEntity();
			eventoEntity.setDescricaoEvento(eventoTO.getDescricaoEvento());
			eventoEntity.setHoraFimEvento(eventoTO.getHoraFimEvento());
			eventoEntity.setHoraInicioEvento(eventoTO.getHoraInicioEvento());
			eventoEntity.setIdEvento(eventoTO.getIdEvento());
			eventoEntity.setLocalEvento(eventoTO.getLocalEvento());
			eventoEntity.setNomeEvento(eventoTO.getNomeEvento());
			eventoEntity.setUsuario(entity);
			
			lstEvento.add(eventoEntity);
		}
*/		
		entity.setEventos(lstEvento);
		
		return entity;
	}
	
	@Override
	public BaseTO convertaEntityParaTO(Object entity) {
		UsuarioEntity usuEntity = (UsuarioEntity) entity;
		UsuarioTO to = new UsuarioTO();
		to.setEmailUsuario(usuEntity.getEmailUsuario());
		to.setIdUsuario(usuEntity.getIdUsuario());
		to.setLoginUsuario(usuEntity.getLoginUsuario());
		to.setNomeUsuario(usuEntity.getNomeUsuario());
		to.setSenhaUsuario(usuEntity.getSenhaUsuario());
		to.setTelefoneUsuario(usuEntity.getTelefoneUsuario());
		return to;
	}
	
	@Override
	public void setEntityManager(EntityManager manager) {
		this.setManager(manager);
	}

}
