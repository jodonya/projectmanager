package com.asal.projectmanager.domain;

import java.util.List;

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
 * Purpose : Posts in a forum
 **/
@Entity
@DiscriminatorValue(value="FORUMPOST")
@Table(name="forumpost")


public class ForumPost extends DomainObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="forum_id")
	
	private Forum forum;
	private String name;
	private Long upcount;
	private Long downcount;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="forumPost")
	private List<PostComment> listComments; 

	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUpcount() {
		return upcount;
	}
	public void setUpcount(Long upcount) {
		this.upcount = upcount;
	}
	public Long getDowncount() {
		return downcount;
	}
	public void setDowncount(Long downcount) {
		this.downcount = downcount;
	}
	
	
	public List<PostComment> getListComments() {
		return listComments;
	}
	public void setListComments(List<PostComment> listComments) {
		this.listComments = listComments;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		ForumPost other = (ForumPost) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
