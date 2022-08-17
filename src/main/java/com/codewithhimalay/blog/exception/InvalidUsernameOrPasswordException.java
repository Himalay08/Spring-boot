package com.codewithhimalay.blog.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidUsernameOrPasswordException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	String message;

	public InvalidUsernameOrPasswordException(String message) {
		super(message);
		this.message = message;
	}
	
	
}
