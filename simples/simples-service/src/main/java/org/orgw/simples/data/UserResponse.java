package org.orgw.simples.data;

import java.io.Serializable;

public class UserResponse implements Serializable {

	private String employeid;
	private String password;
	private String ip;
	private String id;
	private String dateTime;
	private String status;
	
	public String getEmployeid() {
		return employeid;
	}
	public void setEmployeid(String employeid) {
		this.employeid = employeid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
