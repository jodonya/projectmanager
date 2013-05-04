package com.asal.projectmanager.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/****
 *@author japheth
 *
 * Purpose : Responsibility
 **/
@Entity
@DiscriminatorValue(value="ADRESPONSIBILITY")
@Table(name="advertresponsibility")
public class AdvertResponsibilty extends DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="advert_id")
	private Advert advert;
	
	@Column(length=2000)
	private String name;
	public Advert getAdvert() {
		return advert;
	}
	public void setAdvert(Advert advert) {
		this.advert = advert;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return advert + " - " + name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((advert == null) ? 0 : advert.hashCode());
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
		AdvertResponsibilty other = (AdvertResponsibilty) obj;
		if (advert == null) {
			if (other.advert != null)
				return false;
		} else if (!advert.equals(other.advert))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

}
