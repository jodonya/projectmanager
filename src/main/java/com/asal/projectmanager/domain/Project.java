package com.asal.projectmanager.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*****
 * @author japheth
 * 
 * **/
@Entity
@Table(name="projects")
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1075676349487009716L;


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
	private String code;
	private String name;
	private Long NoOfDays;
	private String description;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_manager_id")
	private ProjectUser projectManager;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_type_id")
	private ProjectType projectType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_category_id")
	private ProjectCategory projectCategory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_sponsor_id")
	private ProjectUser projectSponsor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_status_id")
	private ProjectStatus projectStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_location_id")
	private Location location;
	
	@Column(name="summary_budget")
	private Double summaryBudget;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ProjectUser getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectUser projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	public ProjectUser getProjectSponsor() {
		return projectSponsor;
	}

	public void setProjectSponsor(ProjectUser projectSponsor) {
		this.projectSponsor = projectSponsor;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Double getSummaryBudget() {
		return summaryBudget;
	}

	public void setSummaryBudget(Double summaryBudget) {
		this.summaryBudget = summaryBudget;
	}
	
	public Long getNoOfDays() {
		return NoOfDays;
	}

	public void setNoOfDays(Long noOfDays) {
		NoOfDays = noOfDays;
	}

	@Override
	public String toString() {
		return  name ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Project other = (Project) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
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
