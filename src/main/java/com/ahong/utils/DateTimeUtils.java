package com.ahong.utils;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
	
	protected static final String dateTimeString = "yyyy-MM-dd HH:mm:ss";
	protected static final String briefDateTimeString = "yyyy-M-d HH:mm:ss";
	protected static final String dateString = "yyyy-MM-dd";
	protected static final String briefDateString = "yyyy-M-d";
	protected static final String yearMonthString = "yyyy-MM";
	protected static final String shortTimeString = "HH:mm";
	protected static final String timeString = "HH:mm:ss";
	
	private final static Logger log = LoggerFactory.getLogger(DateTimeUtils.class);
	
	/**
	 * SimpleDateFormatTest的parse与format
	 */
	@Test
	public void SimpleDateFormatTest(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String nowStringTime = sdf.format(new Date());
		Date nowDateTime = null;
		try {
			nowDateTime = sdf.parse("2017-1-10 12:23:35");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("nowStringTime:"+nowStringTime);
		System.out.println("nowDateTime:"+nowDateTime);
	}
	
	@Test
	public void CalendarTest(){
		Date date = Calendar.getInstance().getTime();
		System.out.println("date:"+date);
	}
	
	/**
	 * 返回日期格式的字符串,忽略时间
	 * @param date 
	 * @return 日期("2017-01-10")
	 */
	public static String formatDate(Date date) {	
		return new SimpleDateFormat(dateString).format(date);
	}
	
	/**
	 * 返回自定义日期格式的字符串,忽略时间
	 * @param date
	 * @param expression 自定义时间格式(如:"yyyy/MM/dd")
	 * @return
	 */
	public static String formatDate(Date date,String expression) {
		DateFormat format = new SimpleDateFormat(expression);
		return format.format(date);
	}

	/**
	 * 返回时分秒格式的字符串,忽略日期
	 * @param date
	 * @return 时间("23:21:49")
	 */
	public static String formatTime(Date date) {
		return new SimpleDateFormat(timeString).format(date);
	}

	/**
	 * 返回时分格式的字符串,忽略日期和秒
	 * @param date
	 * @return 短时间("23:21")
	 */
	public static String formatShortTime(Date date) {
		return new SimpleDateFormat(shortTimeString).format(date);
	}

	/**
	 * 返回年月日时分秒的字符串
	 * @param date
	 * @return 日期时间("2017-01-10 23:44:21")
	 */
	public static String formatDateTime(Date date) {
		return new SimpleDateFormat(dateTimeString).format(date);
	}

	/**
	 * 返回Date类型,包括日期时间
	 * @param dateTime 日期时间("2017-01-10 12:23:35")
	 * @return
	 * @throws Exception 
     */
	public static Date parseDateTime(String dateTime){
		try {
			return new SimpleDateFormat(dateTimeString).parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回Date类型,包括日期时间
	 * @param dateTime 日期时间("2017-1-10 12:23:35")
	 * @return
	 * @throws Exception 
	 */
	public static Date parseDateTimeBrief(String dateTime){
		try {
			return new SimpleDateFormat(briefDateTimeString).parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回Date类型,包括日期,时分秒均为0
	 * @param date 日期,忽略时间("2017-01-10")
	 * @return
     */
	public static Date parseDay(String date){
		try {
			Date targetDate = new SimpleDateFormat(dateString).parse(date);
			return DateUtils.truncate(targetDate,Calendar.HOUR_OF_DAY);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 返回Date类型,包括日期,时分秒均为0
	 * @param date 日期,忽略时间("2017-1-10")
	 * @return
	 */
	public static Date parseDayBrief(String date){
		try {
			Date targetDate = new SimpleDateFormat(briefDateString).parse(date);
			return DateUtils.truncate(targetDate,Calendar.HOUR_OF_DAY);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回Date类型,日期为指定年月的第一天,时分秒均为0
	 * @param yearMonth 年月，忽略日、时分秒("2017-02")
	 * @return
     */
	public static Date parseYearAndMonth(String yearMonth){
		try {
			Date targetDate = new SimpleDateFormat(yearMonthString).parse(yearMonth);
			return DateUtils.truncate(targetDate,Calendar.DAY_OF_MONTH);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回Date类型,仅包括时间(时分秒),忽略日期
	 * @param time 时间,忽略日期（"12:23:35")
	 * @return
     */
	public static Date parseTime(String time){
		try {
			return new SimpleDateFormat(timeString).parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回Date类型,仅包括时间(时分),忽略日期和秒
	 * @param shortTime 时间(时分),忽略日期和秒（"12:23")
	 * @return
	 */
	public static Date parseShortTime(String shortTime){
		try {
			return new SimpleDateFormat(shortTimeString).parse(shortTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回当前时间
	 */
	public static Date currentTime() {
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * 返回当前时间的毫秒数
	 */
	public static long currentTimeInMillisecond(){
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * 获取今天刚开始时间
	 */
	public static Date getTodayStartTime(){
		Date targetTime = Calendar.getInstance().getTime();
		targetTime = DateUtils.truncate(targetTime,Calendar.DAY_OF_MONTH);
		return targetTime;
	}

	/**
	 * 获取今天的最后时间
	 */
	public static Date getTodayEndTime(){
		Date targetTime = Calendar.getInstance().getTime();
		targetTime = DateUtils.truncate(targetTime,Calendar.DAY_OF_MONTH);
		targetTime = DateUtils.addDays(targetTime,1);
		targetTime = DateUtils.addSeconds(targetTime,-1);
		return targetTime;
	}

	
	/**
	 * 获取指定年月的第一天的0点0分0秒的 Date格式
	 * @param year 四位表示的年,如2001
	 * @param month 两位表示的月,如01,从01开始
	 * @return
	 */
	public static Date getBeginTimeOfYearAndMonth(String year,String month){
		String timeString = year + "-" + month;
		Date targetTime = parseYearAndMonth(timeString);
		return targetTime;
	}

	/**
	 * 获取指定年月的最后一天的23点59分59秒的Date格式(注意:精确度为秒)
	 * @param year 四位表示的年,如2001
	 * @param month 两位表示的月,如01,从01开始
	 * @return
	 */
	public static Date getEndTimeOfYearAndMonth(String year,String month){
		String timeString = year + "-" + month;
		Date targetTime = parseYearAndMonth(timeString);
		targetTime = DateUtils.addMonths(targetTime,1);
		targetTime = DateUtils.addSeconds(targetTime,-1);
		return targetTime;
	}

	protected static void printDateTime(Date date){
		System.out.println(formatDateTime(date));
	}

	public static void main(String[] args){
		printDateTime(getTodayStartTime());
		printDateTime(getTodayEndTime());

		printDateTime(getBeginTimeOfYearAndMonth("2017","2"));
		printDateTime(getEndTimeOfYearAndMonth("2017","2"));
	}

}
