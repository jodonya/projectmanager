package com.asal.projectmanager.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "ASSIGNCATEGORY")
@Table(name = "assigncategory")
public class AssignCategory extends DomainObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "advert_id")
	private Advert advert;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private AdvertCategory advertCategory;

	public Advert getAdvert() {
		return advert;
	}

	public void setAdvert(Advert advert) {
		this.advert = advert;
	}

	public AdvertCategory getAdvertCategory() {
		return advertCategory;
	}

	public void setAdvertCategory(AdvertCategory advertCategory) {
		this.advertCategory = advertCategory;
	}
	

}
