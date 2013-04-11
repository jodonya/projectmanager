package com.asal.projectmanager.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="NOTIFICATION")
@Table(name="notification")

public class Notification  extends DomainObject{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="receipient")
	private ProjectUser receipient;
	private String message;
	public ProjectUser getReceipient() {
		return receipient;
	}
	public void setReceipient(ProjectUser receipient) {
		this.receipient = receipient;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
