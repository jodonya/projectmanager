package com.asal.projectmanager.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asal.projectmanager.domain.ProjectUser;

@Component
@Scope("session")
public class ProjectManagerSession {
	private static ProjectUser user;

	public static ProjectUser getUser() {
		return user;
	}

	public static void setUser(ProjectUser auser) {
		user = auser;
	}
}
