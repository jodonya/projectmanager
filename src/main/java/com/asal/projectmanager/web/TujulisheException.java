package com.asal.projectmanager.web;

public class TujulisheException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String customMessage;
	
	public TujulisheException(String customMessage){
		this.customMessage = customMessage;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	
	
}
