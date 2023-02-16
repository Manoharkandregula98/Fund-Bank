package com.fundsbank.util;

import java.util.Base64;

public class PasswordHandler {
	public String getDecoded(String encStr) {
		byte[] decBytes = Base64.getDecoder().decode(encStr);
		String decStr = new String(decBytes);
		return decStr;
		
	}
	public String getEncoded(String str) {
		String encStr = Base64.getEncoder().encodeToString(str.getBytes());
		return encStr;
	}

	public static void main(String[] args) {
		String str = "root";
		String encStr = new PasswordHandler().getEncoded(str);
		System.out.println(encStr);
		String decStr = new PasswordHandler().getDecoded(encStr);
		System.out.println(decStr);
		
	}

}
