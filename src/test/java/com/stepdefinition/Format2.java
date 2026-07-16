package com.stepdefinition;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Format2 {

	public static long getDateFromJiffy(long dtVal)
	  {
	    long retDate = (int)(dtVal / 65536L) + 315513000l;
	    return retDate;
	  }
	public static long getDateFromNonJiffy(long dtVal)
	 {
		 long retDate = (dtVal + 315513000l);
		 return retDate;
	 }
	public static long getDateFromNonJiffy1(long dtVal)
	 {
		 return dtVal;
	 }	
	
	public static void main(String[] args){
			String param1="1";
			String param2="91805790109696";
		int count=0;
		for (String arg : args) {
           if(count==0)
              param1= arg;
           else if(count==1)
              param2=arg;
			count++;
		}
	
		int type=Integer.parseInt(param1);
		long dt= Long.parseLong(param2);
		
		if(type==1){
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
		 simpleDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        long dateTime = getDateFromJiffy(dt);
		 Date newDate = new Date(dateTime * 1000);
		 String date = simpleDateFormat.format(newDate);
		 System.out.println(date);
		}
		else if(type==2){
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
		 simpleDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		 long dateTime3 = getDateFromNonJiffy(dt);
		 Date newDate3 = new Date(dateTime3 * 1000);
		 String date3 = simpleDateFormat.format(newDate3);
		 System.out.println(date3);	
		}
	}
}
