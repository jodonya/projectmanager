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
@Table(name="projectphase")
public class ProjectPhase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7108923837670591880L;


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
	private String name;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_status_id")
	private ProjectStatus status;
	
	private Long phaseDuration;
	

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	

	public Long getPhaseDuration() {
		return phaseDuration;
	}

	public void setPhaseDuration(Long phaseDuration) {
		this.phaseDuration = phaseDuration;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProjectPhase other = (ProjectPhase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

}
