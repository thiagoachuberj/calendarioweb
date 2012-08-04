package br.com.calendweb.usuario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.calendweb.dao.AbstractDAO;
import br.com.calendweb.evento.entity.EventoEntity;
import br.com.calendweb.exceptions.BusinessException;
import br.com.calendweb.to.BaseTO;
import br.com.calendweb.usuario.entity.UsuarioEntity;
import br.com.calendweb.usuario.to.UsuarioTO;

public class GerenciadorUsuarioDAO extends AbstractDAO implements UsuarioDAO {

	public GerenciadorUsuarioDAO (EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public UsuarioTO buscarUsuarioPorLogin(String loginUsuario)	throws BusinessException {
		UsuarioEntity entity = manager.find(UsuarioEntity.class, Integer.parseInt(loginUsuario));
		UsuarioTO to = null;
		if (entity != null) {
			to = (UsuarioTO) convertaEntityParaTO(to);
		}
		return to;
	}

	@Override
	public void criarUsuario(UsuarioTO usuarioTO) throws BusinessException {
		UsuarioEntity entity = (UsuarioEntity) convertaTOParaEntity(usuarioTO);
		manager.persist(entity);
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
	
	public void setEntityManager(EntityManager manager) {
		this.manager = manager;
	}

}
