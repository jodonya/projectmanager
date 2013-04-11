package com.asal.projectmanager.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="PHOTO")
@Table(name="photo")
public class Photo extends DomainObject {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	
	@Column(name="contenttype")
	private String contentType;
	
	@Column(name="length")
	private Integer length;

	@Column(name="thumblength")
	private Long thumbLength;

	
	@Column(name="content")
	@Lob
	private Blob content;
	
	@Column(name="thumbnailcontent")
	@Lob
	private Blob thumbNailContent;
	
	@Column(name="isdefault")
	private Boolean isDefault;
	
	@Column(name="isprofilephoto")
	private Boolean isProfilePhoto;
	
	@Column(name="newname")
	private String newname;
	
	@Column(name="thumbnailname")
	private String thumbnailname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getIsProfilePhoto() {
		return isProfilePhoto;
	}

	public void setIsProfilePhoto(Boolean isProfilePhoto) {
		this.isProfilePhoto = isProfilePhoto;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public Blob getThumbNailContent() {
		return thumbNailContent;
	}

	public void setThumbNailContent(Blob thumbNailContent) {
		this.thumbNailContent = thumbNailContent;
	}

	public String getThumbnailname() {
		return thumbnailname;
	}

	public void setThumbnailname(String thumbnailname) {
		this.thumbnailname = thumbnailname;
	}

	public Long getThumbLength() {
		return thumbLength;
	}

	public void setThumbLength(Long thumbLength) {
		this.thumbLength = thumbLength;
	}

	

}
