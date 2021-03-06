package br.com.calendweb.login.to;

import br.com.calendweb.to.BaseTO;

/**
 * Java Bean representando o login.
 * @author mek
 */
public class LoginTO extends BaseTO{

	private static final long serialVersionUID = 1L;
	private String login;
	private byte[] senha;
	private String senhaStr;
	
	public String getSenhaStr() {
		return senhaStr;
	}
	public void setSenhaStr(String senhaStr) {
		this.senhaStr = senhaStr;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public byte[] getSenha() {
		return senha;
	}
	public void setSenha(byte[] senha) {
		this.senha = senha;
	}
}
