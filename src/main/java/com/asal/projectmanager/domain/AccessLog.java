package com.asal.projectmanager.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ACCESSLOG")
@Table(name = "accesslog")
public class AccessLog extends DomainObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	private Long count;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	

}
