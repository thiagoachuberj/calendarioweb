package br.com.calendweb.usuario.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.calendweb.evento.entity.EventoEntity;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="USUARIO")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="EMAIL_USUARIO")
	private String emailUsuario;

	@Column(name="LOGIN_USUARIO")
	private String loginUsuario;

	@Column(name="NOME_USUARIO")
	private String nomeUsuario;

	@Column(name="SENHA_USUARIO")
	private String senhaUsuario;

	@Column(name="TELEFONE_USUARIO")
	private String telefoneUsuario;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="usuario")
	private List<EventoEntity> eventos;

    public UsuarioEntity() {
    }

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getLoginUsuario() {
		return this.loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getTelefoneUsuario() {
		return this.telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public List<EventoEntity> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<EventoEntity> eventos) {
		this.eventos = eventos;
	}
	
}