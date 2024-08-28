package com.customer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Customer {
	@Id
	Integer cid;
	@Column
	String cname;
	String email;
	
//	constructor

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Integer cid, String cname, String email) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.email = email;
}
//	Getter an setter
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	to string
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + "]";
	}
	
	

}