package org.orgw.simples.core.util;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilHelper {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private UtilHelper() {
	}

	public static Boolean isEmpty(String value) {
		return value == null || "".equals(value);
	}

	public static String getSystemDate() {
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dt);
	}

	public static String getTime(String date) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "00:00:00";
		try {
			time = new SimpleDateFormat("HH:mm:ss").format(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	
	public static Boolean isEqual(String value1,String value2){
		return !isEmpty(value1) && !isEmpty(value2) && value1.equals(value2) ? true : false;
	}
	
	
	
	public static String formatCurrency(String amount){
		Locale locale = new Locale("en", "US");      
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(Double.parseDouble(amount));		
	}
	
	public static String formatStripeAmt(String amount){
		return String.valueOf(Math.round(Double.parseDouble(amount)*100));		
	}
	
	public static Boolean isNotEqual(String value1,String value2){
		return !isEqual(value1,value2);
	}

	public static String avoidNull(String value) {
		return isEmpty(value) ? "" : value;
	}
	
	public static String avoidNull(Object value) {
		return value==null ? "" : String.valueOf(value);
	}

	public static String getSystemDate(String format) {
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		return sdf.format(dt);
	}

	public static String formatDate(String date) {
		if (!isEmpty(date)) {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date parse = sdf.parse(date);
				return sdf.format(parse);
			} catch (ParseException e) {				
				return date;
			}
		}
		return date;
	}
	
	public static String formatDate(Long cal) {
		java.util.Date dt = new java.util.Date(cal);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dt);
	}
	
	

	public static String formatDate(String date, String format) {
		if (!isEmpty(date)) {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
			try {
				Date parse = sdf.parse(date);
				return sdf.format(parse);
			} catch (ParseException e) {
				return date;
			}
		}
		return date;
	}

	/**
	 * 
	 * @return
	 */
	public static String generateOTP() {
		List<Integer> numbers = new ArrayList<Integer>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }
	    Collections.shuffle(numbers);
	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }
	    return result;
	}
	
	

	public static Boolean isEmail(String email) {
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return !matcher.matches();
	}

	public static String generateRandomCode(int codeLength) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new SecureRandom();
		for (int i = 0; i < codeLength; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString().toUpperCase();
		return output;
	}
	
	

	public static void main(String[] args) throws ParseException {
		/*
		 * //System.out.println(UtilHelper.formatDate("2017-10-05 00:32:43.0"));
		 * Set<String> noDuplicate= new HashSet<String>(); Set<String>
		 * duplicate= new HashSet<String>(); for (int i = 0; i < 5; i++) {
		 * String no = UtilHelper.generateRandomCode(8).toUpperCase();
		 * System.out.println(duplicate.add(no.toUpperCase()));
		 * if(!duplicate.add(no.toUpperCase())){
		 * noDuplicate.add(no.toUpperCase()); } }
		 * System.out.println(duplicate.size());
		 * System.out.println(noDuplicate);
		 */
		//System.out.println(UtilHelper.getTime("2017-10-05 19:32:43.0"));
		/*Set<String> set = new HashSet<String>();
		Set<String> dup = new HashSet<String>();
		for (int i = 0; i < 9999; i++) {
			String generateOTP = generateOTP();
			if(!set.add(generateOTP)){
				dup.add(generateOTP);
			}
		}
		System.out.println(dup);
		*/
		System.out.println(formatDate(Long.valueOf("1508853387000")));
	}
}
