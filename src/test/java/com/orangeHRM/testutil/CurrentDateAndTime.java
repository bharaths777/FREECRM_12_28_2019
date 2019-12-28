package com.orangeHRM.testutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.orangeHRM.testbase.CRMProBase;

public class CurrentDateAndTime extends CRMProBase{

	
	public static String getDateAndTime(){
		
		Date cdate = new Date();
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		return format.format(cdate);
	}
}
