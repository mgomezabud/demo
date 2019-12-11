package com.example.demo.exceptions;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;

import com.example.demo.dto.ErrorCode;

@RestControllerAdvice
public class GlobalErrorWebExceptionHandler {
	private static final Logger LOGGER = Logger.getLogger(GlobalErrorWebExceptionHandler.class.getName());

	private static ErrorCode defaultError() {
		return new ErrorCode(UUID.randomUUID().toString(), "ERROR_DESCONOCIDO");
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode handleException(Exception e) {
		logException(e);
		return defaultError();
	}

	@ExceptionHandler(RegistroNoExistenteException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorCode handleRegistroNoExistenteException(RegistroNoExistenteException e) {
		logException(e);
		return new ErrorCode(UUID.randomUUID().toString(), e.getMessage());
	}

	private void logException(Exception e) {
		LOGGER.severe(e.getClass().getName());
		LOGGER.log(Level.SEVERE, e.getMessage(), e);
	}
}
