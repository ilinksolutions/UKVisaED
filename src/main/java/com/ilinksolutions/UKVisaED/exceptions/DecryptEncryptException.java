package com.ilinksolutions.UKVisaED.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class DecryptEncryptException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DecryptEncryptException(String error) {
		super(error); 
	}

}