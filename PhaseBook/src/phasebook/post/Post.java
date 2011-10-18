package phasebook.post;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import phasebook.user.PhasebookUser;


@Entity
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="FROM_USER")
	private PhasebookUser fromUser;
	@Column(name="TO_USER")
	private PhasebookUser toUser;
	@Column(name="PRIVATE_")
	private boolean private_;
	@Column(name="READ_")
	private boolean read_;
	@Column(name="CREATED_AT")
	private Date createdAt;
	@Column(name="DELETED_AT")
	private Date deletedAt;
	
	protected Post()
	{
		super();
	}
	
	protected Post(PhasebookUser from, PhasebookUser to)
	{
		super();
		this.fromUser = from;
		this.toUser = to;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected PhasebookUser getFromUser() {
		return fromUser;
	}

	protected void setFromUser(PhasebookUser fromUser) {
		this.fromUser = fromUser;
	}

	protected PhasebookUser getToUser() {
		return toUser;
	}

	protected void setToUser(PhasebookUser toUser) {
		this.toUser = toUser;
	}

	protected boolean isPrivate_() {
		return private_;
	}

	protected void setPrivate_(boolean private_) {
		this.private_ = private_;
	}

	protected boolean isRead_() {
		return read_;
	}

	protected void setRead_(boolean read_) {
		this.read_ = read_;
	}

	protected Date getCreatedAt() {
		return createdAt;
	}

	protected void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	protected Date getDeletedAt() {
		return deletedAt;
	}

	protected void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	
}