package com.tog.component;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.lang.NonNull;


@MappedSuperclass
public abstract class BaseEntity {
	
	@NonNull
	@Column(name="created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	@Column(name="created_user")
	private String createdUser;
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	@Column(name="updated_user")
	private String updatedUser;
	@Column(name="deleted")
	@NonNull
	private Boolean deleted = false;
	
	public abstract void setId(Integer id);
	public abstract Integer getId();
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
