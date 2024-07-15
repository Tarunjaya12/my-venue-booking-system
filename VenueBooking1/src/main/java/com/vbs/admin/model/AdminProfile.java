package com.vbs.admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class AdminProfile {
	@Id
	private String emailId;
	private String name;
	private String lastName;
	private String mobileNo;
	private String designation;
	private String organization;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String gmailId) {
		this.emailId = gmailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	@Override
	public String toString() {
		return "UserProfile [emailId=" + emailId + ", name=" + name + ", lastName=" + lastName + ", mobileNo="
				+ mobileNo + ", designation=" + designation + ", organization=" + organization + "]";
	}

}
