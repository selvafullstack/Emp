package org.orgw.simples.data;

import java.io.Serializable;

public class CreateTestRequest implements Serializable {

	private String employeid;
	private String password;
	private String ip;
	
	
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
	
	
}
