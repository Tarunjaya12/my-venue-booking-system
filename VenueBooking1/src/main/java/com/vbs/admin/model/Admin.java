package com.vbs.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 6815099616321942874L;
	@Id
	@Email(message="Enter valid Email Id")
	@NotEmpty
	private String emailId;
	private String name;
	@NotEmpty
	@Size(min=8, message="Password should have at least 8 characters")
	private String password;
	@OneToMany
	private List<Venue> venues = new ArrayList<>();
	
	public List<Venue> getVenues() {
		return venues;
	}
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}

