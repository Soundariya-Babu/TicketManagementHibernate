package com.project.service.exception;

public class ServiceErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceErrorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceErrorException(String message, Exception e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}

	public ServiceErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceErrorException(Exception e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

}
