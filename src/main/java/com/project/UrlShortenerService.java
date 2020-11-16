package com.project;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.validator.routines.UrlValidator;

public class UrlShortenerService {
	private static  Map<String,String> urlMap=new HashMap<>();
	private static final String ab= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom rnd = new SecureRandom();
	
	private String randomString() {
		int len=6;
		StringBuilder sb= new StringBuilder(len);
		for(int i=0;i<len;i++) {
			sb.append(ab.charAt(rnd.nextInt(ab.length())));
		}
		return sb.toString();
	}
	
	public String shorten(String url, String shorten) {
		UrlValidator urlValidator = new UrlValidator(
				new String[] {"http","https"}
		);
		String id = shorten;
		if(urlValidator.isValid(url)) {
			if(shorten=="") {
				id = randomString();
			}
			String shorted = "http://localhost/"+id+"/";
			System.out.println("Short URL generated: " + shorted);
			urlMap.put(id, url);
			return shorted;
		}
		throw new RuntimeException("URL Invalid: " + url);
	}
	
	public String getUrl(String shorted) {
		return urlMap.get(shorted);
	}
}
