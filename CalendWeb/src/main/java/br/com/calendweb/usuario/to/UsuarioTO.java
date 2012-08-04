package br.com.calendweb.usuario.to;

import java.util.List;

import br.com.calendweb.evento.to.EventoTO;
import br.com.calendweb.to.BaseTO;

public class UsuarioTO extends BaseTO {

	private static final long serialVersionUID = 1L;

	private int idUsuario;

	private String emailUsuario;

	private String loginUsuario;

	private String nomeUsuario;

	private String senhaUsuario;

	private String telefoneUsuario;

	//bi-directional many-to-one association to Evento
	private List<EventoTO> eventos;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public List<EventoTO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoTO> eventos) {
		this.eventos = eventos;
	}

}
