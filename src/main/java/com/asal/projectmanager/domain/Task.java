package com.asal.projectmanager.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@DiscriminatorValue(value="TASK")
@Table(name="task")
public class Task extends DomainObject {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3844245369513690999L;


	private String name;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_status_id")
	private ProjectStatus status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_milestone_id")
	private ProjectMilestone milestone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public ProjectMilestone getMilestone() {
		return milestone;
	}

	public void setMilestone(ProjectMilestone milestone) {
		this.milestone = milestone;
	}

}
