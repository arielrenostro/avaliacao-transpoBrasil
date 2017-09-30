package br.com.transpobrasil.crud.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AppException(String msg) {
		super(msg);
	}
}
