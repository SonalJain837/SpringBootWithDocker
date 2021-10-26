package com.topic.RestfulApiSpringBoot.exception;

import java.util.Date;

public class ExceptionFormat {

	private Date timeAndDate;
	private String message;
	private String details;
	
	public ExceptionFormat(Date timeAndDate, String message, String details) {

		this.timeAndDate = timeAndDate;
		this.message = message;
		this.details = details;
	}

	public Date getTimeAndDate() {
		return timeAndDate;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
}

