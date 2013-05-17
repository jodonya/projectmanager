package com.asal.projectmanager.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/****
 * @author japheth
 * 
 *         Purpose : Advert Comments
 **/
@Entity
@DiscriminatorValue(value = "ADCOMMENT")
@Table(name = "adcomment")
public class AdvertComment extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "advert_id")
	private Advert advert;

	@Column(length = 5000)
	private String name;

	// @LazyCollection(LazyCollectionOption.FALSE)
	// fetch=FetchType.EAGER,
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advertComment")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertCommentUp> listAdvertCommentUps;

	// @LazyCollection(LazyCollectionOption.FALSE)
	// fetch=FetchType.EAGER,
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "advertComment")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<AdvertCommentDown> listAdvertCommentDowns;

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

	public Set<AdvertCommentUp> getListAdvertCommentUps() {
		return listAdvertCommentUps;
	}

	public void setListAdvertCommentUps(Set<AdvertCommentUp> listAdvertCommentUps) {
		this.listAdvertCommentUps = listAdvertCommentUps;
	}

	public Set<AdvertCommentDown> getListAdvertCommentDowns() {
		return listAdvertCommentDowns;
	}

	public void setListAdvertCommentDowns(
			Set<AdvertCommentDown> listAdvertCommentDowns) {
		this.listAdvertCommentDowns = listAdvertCommentDowns;
	}

	@Override
	public String toString() {
		return advert + " - " + name;
	}

}
