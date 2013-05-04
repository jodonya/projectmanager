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
@DiscriminatorValue(value="ADVERTUP")
@Table(name="advertup")
public class AdvertUp extends DomainObject {

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
	@Override
	public String toString() {
		return "AdvertUp [advert=" + advert + ", count=" + count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((advert == null) ? 0 : advert.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
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
		AdvertUp other = (AdvertUp) obj;
		if (advert == null) {
			if (other.advert != null)
				return false;
		} else if (!advert.equals(other.advert))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		return true;
	}
	
	

}
