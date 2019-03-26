package org.orgw.simples.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="attendance")
@Entity

public class Attendance {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private String id;
	
	
	@Column(name="empid")
	private String empid;
	
	
	

	@Column(name="Checkin")
	private String checkin;
	
	@Column(name="Checkout")
	private String checkout;
	
	@Column(name="Total_Working_Hours")
	private String totaltime;
	@Column(name="date")
	private String date;

	
	
	
	
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
