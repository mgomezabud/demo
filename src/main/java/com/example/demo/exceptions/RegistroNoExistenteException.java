package com.example.demo.exceptions;

public class RegistroNoExistenteException extends RuntimeException{
	public RegistroNoExistenteException(String mensaje) {
		super(mensaje);
	}

	private static final long serialVersionUID = -7321130980204571758L;

}
