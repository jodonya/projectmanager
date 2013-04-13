package com.asal.projectmanager.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "NOTIFICATION")
@Table(name = "notification")
public class Notification extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "source")
	private ProjectUser source;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "receipient")
	private ProjectUser receipient;

	private String sourceMail; // the system mail and whose name the message was
								// sent
	private String mailSubject;// the subject of the mail

	@Column(length = 1000)
	private String message;

	@Column(name = "issent", columnDefinition = "boolean default false", nullable = true)
	private Boolean isSent;
	
	@Column(name="notificationseen", columnDefinition = "boolean default false", nullable = true)
	private Boolean notificationSeen;


	@Column(name = "whensent")
	private Timestamp whenSent;

	@Column(name = "notificationtype")
	private NotificationType notificationType;

	@Column(name = "notifieetype")
	private NotifieeType notifieeType;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="postedby")
	private ProjectUser postedBy;

	public ProjectUser getReceipient() {
		return receipient;
	}

	public void setReceipient(ProjectUser receipient) {
		this.receipient = receipient;
	}

	public ProjectUser getSource() {
		return source;
	}

	public void setSource(ProjectUser source) {
		this.source = source;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsSent() {
		return isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public Timestamp getWhenSent() {
		return whenSent;
	}

	public void setWhenSent(Timestamp whenSent) {
		this.whenSent = whenSent;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public NotifieeType getNotifieeType() {
		return notifieeType;
	}

	public void setNotifieeType(NotifieeType notifieeType) {
		this.notifieeType = notifieeType;
	}

	public String getSourceMail() {
		return sourceMail;
	}

	public void setSourceMail(String sourceMail) {
		this.sourceMail = sourceMail;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public ProjectUser getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(ProjectUser postedBy) {
		this.postedBy = postedBy;
	}

	@Override
	public String toString() {
		return "Notification [message=" + message + "]";
	}

	@Override
	public int hashCode() {

		// this.setNotificationType(NotificationType.MAIL);
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((receipient == null) ? 0 : receipient.hashCode());
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
		Notification other = (Notification) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (receipient == null) {
			if (other.receipient != null)
				return false;
		} else if (!receipient.equals(other.receipient))
			return false;
		return true;
	}

}
