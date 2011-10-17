package phasebook.friendship;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import phasebook.user.PhasebookUser;

@Entity
public class Friendship implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="FRIENDSHIP_ID")
	private int id;
	
	@Column(name="HOST_PHASEBOOK_USER_ID")
	private PhasebookUser hostUser;
	@Column(name="INVITED_PHASEBOOK_USER_ID")
	private PhasebookUser invitedUser;
	private boolean accepted_;
	@Column(name="CREATED_AT")
	private Date creationDate;
	@Column(name="DELETED_AT")
	private Date deletionDate;
	
	
	protected Friendship()
	{
		super();
	}
	
	protected Friendship(PhasebookUser inviterUser, PhasebookUser inveteeUser) 
	{
		super();
		this.hostUser = inviterUser;
		this.invitedUser = inveteeUser;
	}
	
	private Date getCurrentTime()
	{		
		Calendar currenttime = Calendar.getInstance();
		return new Date((currenttime.getTime()).getTime());
	}

	protected int getId() {
		return id;
	}

	protected void setID(int id) {
		this.id = id;
	}

	protected boolean isAccepted() {
		return accepted_;
	}

	protected void setAccepted(boolean accepted) {
		this.accepted_ = accepted;
	}

	protected Date getCreationDate() {
		return creationDate;
	}

	protected void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	protected Date getDeletionDate() {
		return deletionDate;
	}

	protected void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}
	
	protected void deleteFriendship() {
		this.deletionDate=getCurrentTime();
	}

	protected PhasebookUser getInviterUser() {
		return hostUser;
	}

	protected void setInviterUser(PhasebookUser inviterUser) {
		this.hostUser = inviterUser;
	}

	protected PhasebookUser getInveteeUser() {
		return invitedUser;
	}

	protected void setInveteeUser(PhasebookUser inveteeUser) {
		this.invitedUser = inveteeUser;
	}
	
	
}
