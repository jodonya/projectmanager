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
 * Purpose : Comments to a post
 **/

@Entity
@DiscriminatorValue(value="POSTCOMMENT")
@Table(name="postcomment")
public class PostComment extends DomainObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="forumpost_id")
	private ForumPost forumPost;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="postcomment_id")
	private PostComment parentComment;
	
	private String name;
	private Long upcount;
	private Long downcount;
	public ForumPost getForumPost() {
		return forumPost;
	}
	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}
	public PostComment getParentComment() {
		return parentComment;
	}
	public void setParentComment(PostComment parentComment) {
		this.parentComment = parentComment;
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
		PostComment other = (PostComment) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
