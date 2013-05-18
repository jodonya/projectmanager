package com.asal.projectmanager.web.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.asal.projectmanager.domain.ProjectUser;

@Component
//@Scope("session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProjectManagerSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageSize;
	private int offset;
	private ProjectUser user;
	
	public ProjectManagerSession(){
		pageSize = 5;
		offset = 0;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public ProjectUser getUser() {
		return user;
	}

	public void setUser(ProjectUser auser) {
		user = auser;
	}	
	
}
