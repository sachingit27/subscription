package com.sac.subsscription.entity;

import java.util.Date;

public class Membership {

	private int memid;
	private String firstname;
	private String lastname;
	private String email;
	private Date startdt;
	private Date enddt;
	
	public int getMemid() {
		return memid;
	}
	public void setMemid(int memid) {
		this.memid = memid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getStartdt() {
		return startdt;
	}
	public void setStartdt(Date startdt) {
		this.startdt = startdt;
	}
	public Date getEnddt() {
		return enddt;
	}
	public void setEnddt(Date enddt) {
		this.enddt = enddt;
	}

	@Override
	public String toString() {
		return "Membership [memid=" + memid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", startdt=" + startdt + ", enddt=" + enddt + "]";
	}
	
	
	
}
