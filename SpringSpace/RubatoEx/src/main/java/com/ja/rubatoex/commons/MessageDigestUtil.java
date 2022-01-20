package com.ja.rubatoex.commons;

import java.security.MessageDigest;

public class MessageDigestUtil {

	public static String passwordHashing(String password) {
		
		// salt
		password += "소금후추";
		
		String hashcode = null;
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.reset();
			
			messageDigest.update(password.getBytes("UTF-8"));
			byte[] charHash = messageDigest.digest();
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<charHash.length;i++) {
				String tmp = Integer.toHexString(charHash[i]);
				
				if(tmp.length() == 1) {
					sb.append("0");
				}
				
				sb.append(tmp);
			}
			hashcode = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hashcode;
	}
}
