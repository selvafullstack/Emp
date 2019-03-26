package org.orgw.simples.core.exception;

public enum SimplesConstant {
	OK("SUCCESS"),
	KO("FAILURE"),
	WRONG("SOMETHING WENT WRONG!!"),
	TECH_ERROR("TECHNICAL ERROR"),
	CODE_0("0"),
	CODE_1("1"),
	CODE_2("2"),
	ERROR_1("ERROR_1"),
	NONE("NONE"),
	FAIL("Login Failed"),
	USERAVAILBLE("User Already Exists!!");
	
	
	private String code;
	SimplesConstant(String code){
		this.code = code;
	}
	
	public String getCode(){
		return this.code;
	}	
	
}
