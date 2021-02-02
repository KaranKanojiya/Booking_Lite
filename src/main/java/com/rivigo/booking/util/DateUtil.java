package com.rivigo.booking.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertStringToDate(String stringDate) throws ParseException
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat(Constant.DATE_FORMAT);
		 Date date1=sdf1.parse(stringDate); 
		return date1;
	}
}
