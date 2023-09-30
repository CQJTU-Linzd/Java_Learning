package test.Code06_MoreAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Code06_04_Date {

	// Date类
	public static void test_Date() {
		Date d = new Date();
		System.out.println(d);

		// 拿到时间毫秒值
		long time = d.getTime();
		System.out.println(time);

		// 把时间毫秒值转换成日期对象：2s之后的时间是多少
		time += 2 * 1000;
		Date d2 = new Date(time);
		System.out.println(d2);

		// 把time的时间赋给d3
		Date d3 = new Date();
		d3.setTime(time);
		System.out.println(d3);
	}

	// SimpleDateFormat
	// 把时间格式化成我们习惯看的方式
	public static void test_SimpleDateFormat() throws ParseException {
		Date d = new Date();
		System.out.println(d);
		long time = d.getTime();
		System.out.println(time);

		// 格式化 日期对象 和 时间毫秒值
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
		String rs = sdf.format(d);
		System.out.println(rs);
		String rs2 = sdf.format(time);
		System.out.println(rs2);

		// 字符串时间解析成日期对象
		System.out.println("------------------");
		String dateStr = "2023-9-30 20:57:40";
		// 指定的时间格式必须和传进的字符串一样
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d2 = sdf2.parse(dateStr);
		System.out.println(d2);
	}

	// 判断时间是否在某个时间范围内
	public static void test_TimeInRange() throws ParseException {
		String startTime = "2023-11-11 0:0:0";
		String endTime = "2023-11-11 0:10:0";

		String myTime1 = "2023-11-11 0:07:15";
		String myTime2 = "2023-11-11 0:11:0";

		// 把字符串时间解析成日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date startDt = sdf.parse(startTime);
		Date endDt = sdf.parse(endTime);
		Date myDt1 = sdf.parse(myTime1);
		Date myDt2 = sdf.parse(myTime2);

		// 判断: 转成时间毫秒值
		long startSeconds = startDt.getTime();
		long endSeconds = endDt.getTime();
		long mySeconds1 = myDt1.getTime();
		long mySeconds2 = myDt2.getTime();

		if (startSeconds <= mySeconds1 && mySeconds1 <= endSeconds) {
			System.out.println("Time1 in range!");
		}
		if (startSeconds <= mySeconds2 && mySeconds2 <= endSeconds) {
			System.out.println("Time2 in range!");
		}
	}

	// Calendar
	public static void test_Calendar() {
		// 得到系统此时时间对应的日历对象
		Calendar now = Calendar.getInstance();
		System.out.println(now);

		// 获取日历中的某个信息
		int year = now.get(Calendar.YEAR);
		System.out.println(year);
		int month = now.get(Calendar.MONTH) + 1; // 月份从0开始计数，真实月份要加1
		System.out.println(month);

		// 拿到日历中记录的日期对象
		Date d = now.getTime();
		System.out.println(d);

		// 拿到时间毫秒值
		long time = now.getTimeInMillis();

		// 修改日历的某个信息
		now.set(Calendar.MONTH, 9); // 改成10月
		System.out.println(now);

		// 给某个信息增加或减少
		now.add(Calendar.DAY_OF_YEAR, 100);
		now.add(Calendar.DAY_OF_YEAR, -10);
		now.add(Calendar.HOUR, 6);
	}

	public static void main(String[] args) throws ParseException {
//		test_Date();
//		test_SimpleDateFormat();
//		test_TimeInRange();
		test_Calendar();
	}

}
