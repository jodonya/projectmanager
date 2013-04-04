package com.asal.projectmanager.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asal.projectmanager.domain.ProjectUser;

@Component
@Scope("session")
public class ProjectManagerSession {
	private int pageSize;
	private int offset;
	private static ProjectUser user;
	
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


	public static ProjectUser getUser() {
		return user;
	}

	public static void setUser(ProjectUser auser) {
		user = auser;
	}	
	
}
