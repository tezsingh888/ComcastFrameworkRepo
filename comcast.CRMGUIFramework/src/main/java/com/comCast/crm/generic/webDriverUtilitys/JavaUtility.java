package com.comCast.crm.generic.webDriverUtilitys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNumber() {
	Random random=new Random();
	int randomNumber=random.nextInt(5000);
	return randomNumber;
}
public String getSystemDatayyyyDDmm() {
	Date dateObj=new Date();
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	String date=sim.format(dateObj);
	return date;	
}
public String getRequiredDateyyyyDDmm(int days) {
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal= sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate= sim.format(cal.getTime());
	return reqDate;
}
}
