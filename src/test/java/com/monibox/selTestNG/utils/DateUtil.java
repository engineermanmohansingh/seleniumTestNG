/*
 * 
 */
package com.monibox.selTestNG.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * The Class DateUtil.
 */
public class DateUtil {

	/**
	 * Gets the current date time.
	 * 
	 * @return the current date time
	 */
	public static String getCurrentDateTime() {
		String ranNum = "";
		DateFormat formatter = new SimpleDateFormat("MMM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 1);
		try {
			ranNum = "_" + dformatter.format(dateParse.parse(date))
							+ formatter.format(monthParse.parse(month)) + "_"
							+ Integer.toString(cal.get(Calendar.HOUR_OF_DAY))
							+ Integer.toString(cal.get(Calendar.MINUTE));
		} catch (Exception e) {
		}
		return ranNum;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public static String getDate() {
		DateFormat formatter = new SimpleDateFormat("MM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE));
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String calDate = month + "/" + date + "/" + year;
		return calDate;
	}

	/**
	 * Gets the tommorrows date.
	 * 
	 * @return the tommorrows date
	 */
	public static String getTommorrowsDate() {
		DateFormat formatter = new SimpleDateFormat("MM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 1);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String calDate = month + "/" + date + "/" + year;
		return calDate;
	}

	/**
	 * Gets the tommorrows date fne.
	 * 
	 * @return the tommorrows date fne
	 */
	public static String getTommorrowsDateFne() {
		DateFormat formatter = new SimpleDateFormat("MMM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 1);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String calDate = month + " " + date;
		return calDate;
	}

	/**
	 * Gets the day after tommorrows date.
	 * 
	 * @return the day after tommorrows date
	 */
	public static String getDayAfterTommorrowsDate() {
		DateFormat formatter = new SimpleDateFormat("MM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 2);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String calDate = month + "/" + date + "/" + year;
		return calDate;
	}

	/**
	 * Gets the day after tommorrows date fne.
	 * 
	 * @return the day after tommorrows date fne
	 */
	public static String getDayAfterTommorrowsDateFne() {
		DateFormat formatter = new SimpleDateFormat("MMM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 2);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String calDate = month + " " + date;
		return calDate;
	}

	/**
	 * Gets the day to day after tommorrows date.
	 * 
	 * @return the day to day after tommorrows date
	 */
	public static String getDayToDayAfterTommorrowsDate() {
		DateFormat formatter = new SimpleDateFormat("MM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 3);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String calDate = month + "/" + date + "/" + year;
		return calDate;
	}

	/**
	 * Gets the day to day after tommorrows date fne.
	 * 
	 * @return the day to day after tommorrows date fne
	 */
	public static String getDayToDayAfterTommorrowsDateFne() {
		DateFormat formatter = new SimpleDateFormat("MMM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String date = Integer.toString(cal.get(Calendar.DATE) + 3);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String calDate = month + " " + date;
		return calDate;
	}

	/**
	 * Gets the date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static String getDate(String date) {
		if (date.equalsIgnoreCase("TomorrowDate"))
			return getTommorrowsDate();
		if (date.equalsIgnoreCase("DayAfterTomorrowDate"))
			return getDayAfterTommorrowsDate();
		if (date.equalsIgnoreCase("DayToDayAfterTomorrowDate"))
			return getDayToDayAfterTommorrowsDate();
		return fixedDate();
	}

	/**
	 * Gets the date for fne.
	 * 
	 * @param date
	 *            the date
	 * @return the date for fne
	 */
	public static String getDateForFne(String date) {
		if (date.equalsIgnoreCase("TomorrowDate"))
			return getTommorrowsDateFne();
		if (date.equalsIgnoreCase("DayAfterTomorrowDate"))
			return getDayAfterTommorrowsDateFne();
		if (date.equalsIgnoreCase("DayToDayAfterTomorrowDate"))
			return getDayToDayAfterTommorrowsDateFne();
		return fixedDate();
	}

	/**
	 * Gets the time as per time zone.
	 * 
	 * @param time
	 *            the time
	 * @param timeZOne
	 *            the time z one
	 * @return the time as per time zone
	 */
	public static String getTimeAsPerTimeZone(String time, String timeZOne) {
		time = time.split("Minutes")[1];
		DateFormat formatter = new SimpleDateFormat("hh:mm a");
		TimeZone tz = TimeZone.getTimeZone("EST5EDT");
		Calendar cal = new GregorianCalendar(tz);
		cal.add(Calendar.MINUTE, Integer.parseInt(time));
		formatter.setTimeZone(tz);
		return formatter.format(cal.getTime());
	}

	/**
	 * Fixed date.
	 * 
	 * @return the string
	 */
	public static String fixedDate() {
		return "12/31/2013";
	}

	/**
	 * Gets the current time.
	 * 
	 * @return the current time
	 */
	public static String getCurrentTime() {
		Date date = new Date();
		String strDateFormat = "HH:mm a";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		return (sdf.format(date));
	}
}
