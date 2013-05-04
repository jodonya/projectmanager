package com.asal.projectmanager.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/****
 *@author japheth
 *
 * Purpose : Forums
 **/
@Entity
@DiscriminatorValue(value="ADVERTDOWN")
@Table(name="advertdown")
public class AdvertDown extends DomainObject {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="advert_id")
	private Advert advert;
	
	private Long count;
	public Advert getAdvert() {
		return advert;
	}
	public void setAdvert(Advert advert) {
		this.advert = advert;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	

}
