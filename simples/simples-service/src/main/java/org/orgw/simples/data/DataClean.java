package org.orgw.simples.data;

import org.orgw.simples.core.util.UtilHelper;

public class DataClean {
	private DataClean(){
		
	}
	public static String avoidNull(String value) {
		return UtilHelper.isEmpty(value) ? "" : value;
	}
	
	public static Object avoidNull(Object value) {
		return value==null ? "" : value;
	}
}
