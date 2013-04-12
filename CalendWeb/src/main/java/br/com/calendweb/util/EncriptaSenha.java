package br.com.calendweb.util;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe responsável por realiazar funcoes de encriptacao.
 * 
 * @author mek
 */
public class EncriptaSenha {

	private EncriptaSenha() {
		
	}
	
	/**
	 * Metodo responsavel por realizar a encriptacao da senha.
	 * 
	 * @param senha 
	 * @return []byte 
	 */
	public static byte[] encriptaSenha(String senha) {
		byte []senhaEncriptada = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			
			senhaEncriptada = new byte[200];
			
			md.digest(senhaEncriptada, 0, 200);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (DigestException ex) {
			ex.printStackTrace();
		}
		
		return senhaEncriptada;
	}
	
	public static void main(String []args) {
		byte []senha = EncriptaSenha.encriptaSenha("123");
		System.out.println(senha.toString());
	}

}
