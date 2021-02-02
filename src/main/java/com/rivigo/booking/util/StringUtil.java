package com.rivigo.booking.util;

public class StringUtil {

	public static boolean isNotNullNotEmpty(String value) {
		boolean isNotNullNotEmpty = false;

		if (value != null && !value.trim().equals("")) {
			isNotNullNotEmpty = true;
		}

		return isNotNullNotEmpty;
	}

	public static boolean isNullOrEmpty(String value) {
		boolean isNullOrEmpty = false;

		if (value == null || value.trim().equals("")) {
			isNullOrEmpty = true;
		}

		return isNullOrEmpty;
	}

	
	
	
}
