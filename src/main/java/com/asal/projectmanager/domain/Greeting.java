package com.asal.projectmanager.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/****
 * 
 *@author japheth
 *
 * The Greeting Object
 **/

@Entity
@Table(name="greeting")
public class Greeting implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4846229817016190989L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="greeting_date")
	private Date greetingDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="greeting_text")
	private String greetingText;

	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}

	public Date getGreetingDate() {
		return greetingDate;
	}

	public void setGreetingDate(Date greetingDate) {
		this.greetingDate = greetingDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((greetingText == null) ? 0 : greetingText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		if (greetingText == null) {
			if (other.greetingText != null)
				return false;
		} else if (!greetingText.equals(other.greetingText))
			return false;
		return true;
	}
	
	

}
