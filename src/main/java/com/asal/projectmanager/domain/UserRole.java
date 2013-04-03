package com.asal.projectmanager.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@DiscriminatorValue(value="USERROLE")
@Table(name="userroles")
public class UserRole extends DomainObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7080737541659973163L;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private ProjectUser user;
	private String authority;
	public ProjectUser getUser() {
		return user;
	}
	public void setUser(ProjectUser user) {
		this.user = user;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
