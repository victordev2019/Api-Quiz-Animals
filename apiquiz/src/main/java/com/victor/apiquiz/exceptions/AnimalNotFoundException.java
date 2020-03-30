package com.victor.apiquiz.exceptions;

import com.victor.apiquiz.core.CoreException;

public class AnimalNotFoundException extends CoreException {

	private static final String _DEFAULT_MSG = "Animal não encontrado!";


	public AnimalNotFoundException() {
		super(_DEFAULT_MSG);
	}


	public AnimalNotFoundException(String message) {
		super(message);
	}


	public AnimalNotFoundException(String message, Throwable error) {
		super(message, error);
	}

	public AnimalNotFoundException(Throwable error) {
		super(_DEFAULT_MSG, error);
	}
}
