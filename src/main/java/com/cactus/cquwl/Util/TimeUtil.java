package com.cactus.cquwl.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	
	public static Date stringToDate(String strDate) throws ParseException{
		if(TextUtil.isEmpty(strDate)){
			return null;
		}
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		return date;
	}
	
	public static Date getCurrentDate(){
		return new Date();
	}
	
	public static int getMonths(String date1) throws ParseException{
		
		int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(sdf.format(new Date())));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);
	}
}
