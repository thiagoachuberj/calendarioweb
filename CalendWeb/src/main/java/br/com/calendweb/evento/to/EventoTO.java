package br.com.calendweb.evento.to;

import java.util.Date;

import br.com.calendweb.to.BaseTO;
import br.com.calendweb.usuario.to.UsuarioTO;

public class EventoTO extends BaseTO {

	private static final long serialVersionUID = 1L;

	private int idEvento;

	private String descricaoEvento;

	private Date horaFimEvento;

	private Date horaInicioEvento;

	private String localEvento;

	private String nomeEvento;

	//bi-directional many-to-one association to Usuario
	private UsuarioTO usuario;

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Date getHoraFimEvento() {
		return horaFimEvento;
	}

	public void setHoraFimEvento(Date horaFimEvento) {
		this.horaFimEvento = horaFimEvento;
	}

	public Date getHoraInicioEvento() {
		return horaInicioEvento;
	}

	public void setHoraInicioEvento(Date horaInicioEvento) {
		this.horaInicioEvento = horaInicioEvento;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public UsuarioTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}
}
