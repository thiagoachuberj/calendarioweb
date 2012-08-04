package br.com.calendweb.evento.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.calendweb.usuario.entity.UsuarioEntity;

import java.util.Date;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@Table(name="EVENTO")
public class EventoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVENTO")
	private int idEvento;

	@Column(name="DESCRICAO_EVENTO")
	private String descricaoEvento;

    @Temporal( TemporalType.DATE)
	@Column(name="HORA_FIM_EVENTO")
	private Date horaFimEvento;

    @Temporal( TemporalType.DATE)
	@Column(name="HORA_INICIO_EVENTO")
	private Date horaInicioEvento;

	@Column(name="LOCAL_EVENTO")
	private String localEvento;

	@Column(name="NOME_EVENTO")
	private String nomeEvento;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="IDF_USUARIO")
	private UsuarioEntity usuario;

    public EventoEntity() {
    }

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescricaoEvento() {
		return this.descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Date getHoraFimEvento() {
		return this.horaFimEvento;
	}

	public void setHoraFimEvento(Date horaFimEvento) {
		this.horaFimEvento = horaFimEvento;
	}

	public Date getHoraInicioEvento() {
		return this.horaInicioEvento;
	}

	public void setHoraInicioEvento(Date horaInicioEvento) {
		this.horaInicioEvento = horaInicioEvento;
	}

	public String getLocalEvento() {
		return this.localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public String getNomeEvento() {
		return this.nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public UsuarioEntity getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
}