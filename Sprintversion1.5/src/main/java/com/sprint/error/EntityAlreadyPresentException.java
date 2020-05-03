package com.sprint.error;

@SuppressWarnings("serial")
public class EntityAlreadyPresentException extends RuntimeException{
	
	public EntityAlreadyPresentException(String message) {
		super(message) ;
	}

}
