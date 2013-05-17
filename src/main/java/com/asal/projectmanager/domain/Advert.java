package com.asal.projectmanager.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/****
 * @author japheth
 * 
 *         Purpose : Advert - JOb or Event Advert
 **/
@Entity
@DiscriminatorValue(value = "ADVERT")
@Table(name = "advert")
public class Advert extends DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(length = 1000)
	private String name;
	
	private String location;
	private AdvertType advertType;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "advert_categories",
	joinColumns = @JoinColumn(name = "advert_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
	)
	private Set<AdvertCategory> categoryList;
	
	@Transient
	private String tempDeadLine;

	@Column(length = 50000)
	private String details;

	@Column(length = 2000)
	private String summary;

	private Date deadLine;
	private AdvertPriority advertPriority;
	
	private String sourceName;
	
	private String sourceWebsite;

	// @LazyCollection(LazyCollectionOption.FALSE)
	//
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advert")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertResponsibilty> listResponsibilities;

	// @LazyCollection(LazyCollectionOption.FALSE)
	//
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advert")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertRequirement> listRequirements;

	// @LazyCollection(LazyCollectionOption.FALSE)
	//
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advert")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertUp> listAdvertUp;

	// @LazyCollection(LazyCollectionOption.FALSE)
	//
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advert")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertDown> listAdvertDown;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advert")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertComment> listAdvertComments;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdvertType getAdvertType() {
		return advertType;
	}

	public void setAdvertType(AdvertType advertType) {
		this.advertType = advertType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public AdvertPriority getAdvertPriority() {
		return advertPriority;
	}

	public void setAdvertPriority(AdvertPriority advertPriority) {
		this.advertPriority = advertPriority;
	}

	
	
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<AdvertCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(Set<AdvertCategory> categoryList) {
		this.categoryList = categoryList;
	}
	
	

	public String getTempDeadLine() {
		return tempDeadLine;
	}

	public void setTempDeadLine(String tempDeadLine) {
		this.tempDeadLine = tempDeadLine;
	}
	
	

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceWebsite() {
		return sourceWebsite;
	}

	public void setSourceWebsite(String sourceWebsite) {
		this.sourceWebsite = sourceWebsite;
	}

	public Set<AdvertResponsibilty> getListResponsibilities() {
		return listResponsibilities;
	}

	public void setListResponsibilities(
			Set<AdvertResponsibilty> listResponsibilities) {
		this.listResponsibilities = listResponsibilities;
	}

	public Set<AdvertRequirement> getListRequirements() {
		return listRequirements;
	}

	public void setListRequirements(Set<AdvertRequirement> listRequirements) {
		this.listRequirements = listRequirements;
	}

	public Set<AdvertUp> getListAdvertUp() {
		return listAdvertUp;
	}

	public void setListAdvertUp(Set<AdvertUp> listAdvertUp) {
		this.listAdvertUp = listAdvertUp;
	}

	public Set<AdvertDown> getListAdvertDown() {
		return listAdvertDown;
	}

	public void setListAdvertDown(Set<AdvertDown> listAdvertDown) {
		this.listAdvertDown = listAdvertDown;
	}

	public Set<AdvertComment> getListAdvertComments() {
		return listAdvertComments;
	}

	public void setListAdvertComments(Set<AdvertComment> listAdvertComments) {
		this.listAdvertComments = listAdvertComments;
	}

	@Override
	public String toString() {
		return company + " - " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advert other = (Advert) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
