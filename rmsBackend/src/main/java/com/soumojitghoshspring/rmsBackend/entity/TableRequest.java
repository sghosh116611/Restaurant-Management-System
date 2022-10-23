package com.soumojitghoshspring.rmsBackend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_request")
public class TableRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private int mobile;
	
	@Column(name = "seating_capacity")
	private int capacity;
	
	@Column(name = "request_date")
	private Date requestDate;
	
	
	public TableRequest() {
		// TODO Auto-generated constructor stub
	}


	public TableRequest(String fullName, String email, int mobile, int capacity, Date requestDate) {
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.capacity = capacity;
		this.requestDate = requestDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Date getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}


	@Override
	public String toString() {
		return "TableRequest [id=" + id + ", fullName=" + fullName + ", email=" + email + ", mobile=" + mobile
				+ ", capacity=" + capacity + ", requestDate=" + requestDate + "]";
	}
	
	
}
