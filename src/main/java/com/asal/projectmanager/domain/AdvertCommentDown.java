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
 * Purpose : Advert Comment Down
 **/
@Entity
@DiscriminatorValue(value="ADCOMMENTDOWN")
@Table(name="advercommentdown")
public class AdvertCommentDown extends DomainObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="advertcomment_id")
	private AdvertComment advertComment;
	
	private Long count;
	
	public AdvertComment getAdvertComment() {
		return advertComment;
	}
	public void setAdvertComment(AdvertComment advertComment) {
		this.advertComment = advertComment;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AdvertCommentDown [advertComment=" + advertComment + ", count="
				+ count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((advertComment == null) ? 0 : advertComment.hashCode());
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
		AdvertCommentDown other = (AdvertCommentDown) obj;
		if (advertComment == null) {
			if (other.advertComment != null)
				return false;
		} else if (!advertComment.equals(other.advertComment))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		return true;
	}
	
	
}
