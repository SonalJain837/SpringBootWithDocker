package com.topic.RestfulApiSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class TopicNotSaveException extends RuntimeException {

	public TopicNotSaveException(String message) {
		super(message);
		
	}
	
}
