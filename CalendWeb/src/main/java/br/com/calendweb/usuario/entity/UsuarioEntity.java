package br.com.calendweb.usuario.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.calendweb.evento.entity.EventoEntity;


/**
 * The persistent class for the usuario database table.
 * 
 */
@NamedNativeQueries ({
	@NamedNativeQuery (name = "consultaUsuario",
						query  =  "select * from " 
								+ "usuario u "
								+ " where u.usu_login = :login ", 
								//+ " and u.usu_senha = :senha",
						resultClass  =  UsuarioEntity.class
	),
	@NamedNativeQuery (name="consultaTodosUsuario",
						query = "select * from " 
								+ " usuario u ",
						resultClass = UsuarioEntity.class
	)						
})
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID  =  1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private int idUsuario;

	@Column(name = "usu_email")
	private String emailUsuario;

	@Column(name = "usu_login")
	private String loginUsuario;

	@Column(name = "usu_nome")
	private String nomeUsuario;

	@Column(name = "usu_senha")
	private byte[] senhaUsuario;

	@Column(name = "usu_telefone")
	private String telefoneUsuario;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy = "usuario")
	private List<EventoEntity> eventos;

	/**
	 * Construtor padrao.
	 */
    public UsuarioEntity() {
    }

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * @param emailUsuario the emailUsuario to set
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * @return the loginUsuario
	 */
	public String getLoginUsuario() {
		return loginUsuario;
	}

	/**
	 * @param loginUsuario the loginUsuario to set
	 */
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * @param nomeUsuario the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * @return the senhaUsuario
	 */
	public byte[] getSenhaUsuario() {
		return senhaUsuario;
	}

	/**
	 * @param senhaUsuario the senhaUsuario to set
	 */
	public void setSenhaUsuario(byte[] senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	/**
	 * @return the telefoneUsuario
	 */
	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	/**
	 * @param telefoneUsuario the telefoneUsuario to set
	 */
	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	/**
	 * @return the eventos
	 */
	public List<EventoEntity> getEventos() {
		return eventos;
	}

	/**
	 * @param eventos the eventos to set
	 */
	public void setEventos(List<EventoEntity> eventos) {
		this.eventos = eventos;
	}

}