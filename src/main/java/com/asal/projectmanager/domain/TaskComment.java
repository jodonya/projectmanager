package com.asal.projectmanager.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="taskcomment")
public class TaskComment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -762090199342292924L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private Timestamp created;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="createdby")
	private ProjectUser createdBy;
	
	private Timestamp updated;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="updatedby")
	private ProjectUser updatedBy;
	
	@Column(name="isactive")
	private String isActive;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="task_id")
	Task task;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_comment_id")
	TaskComment parentComment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public ProjectUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(ProjectUser createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public ProjectUser getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(ProjectUser updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskComment getParentComment() {
		return parentComment;
	}

	public void setParentComment(TaskComment parentComment) {
		this.parentComment = parentComment;
	}

	@Override
	public String toString() {
		return "TaskComment [description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskComment other = (TaskComment) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
