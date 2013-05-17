package com.asal.projectmanager.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/****
 *@author japheth
 *
 * Purpose : Register Companies / Businesses
 **/
@Entity
@DiscriminatorValue(value="COMPANY")
@Table(name="company")
public class Company extends DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length=500)
	private String name;
	private String location;
	private String contactPerson;
	private String phoneNo;
	private String email;
	private String webaddress;
	private String facebookpage;
	private String twitterhandle;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="photo_id")
	private CompanyPhoto companyPhoto;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="company")
	private Set<Advert> listAdvert; 

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebaddress() {
		return webaddress;
	}
	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}
	public String getFacebookpage() {
		return facebookpage;
	}
	public void setFacebookpage(String facebookpage) {
		this.facebookpage = facebookpage;
	}
	public String getTwitterhandle() {
		return twitterhandle;
	}
	public void setTwitterhandle(String twitterhandle) {
		this.twitterhandle = twitterhandle;
	}
	
	
	public CompanyPhoto getCompanyPhoto() {
		return companyPhoto;
	}
	public void setCompanyPhoto(CompanyPhoto companyPhoto) {
		this.companyPhoto = companyPhoto;
	}
	
	public Set<Advert> getListAdvert() {
		return listAdvert;
	}
	public void setListAdvert(Set<Advert> listAdvert) {
		this.listAdvert = listAdvert;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Company other = (Company) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
