package br.com.calendweb.exceptions;

import org.apache.log4j.Logger;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger(BusinessException.class);
	private static final String NOME_PROJETO = "CALEND_WEB";
	
	public BusinessException() {
		
	}
	
	public BusinessException(Exception ex) {
		log.error(NOME_PROJETO +": ####" +ex.getMessage());
	}

}
