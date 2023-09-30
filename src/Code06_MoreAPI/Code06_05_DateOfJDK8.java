package test.Code06_MoreAPI;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Code06_05_DateOfJDK8 {

	// LocalDate
	public static void test_LocalDate() {
		// 获取本地日期对象
		LocalDate ld = LocalDate.now(); // 年 月 日
		System.out.println(ld);

		// 获取日期对象中的信息
		int year = ld.getYear();
		int month = ld.getMonthValue();
		int day = ld.getDayOfMonth();
		int dayOfYear = ld.getDayOfYear();
		int dayOfWeek = ld.getDayOfWeek().getValue();
		System.out.println(dayOfWeek);

		// 直接修改某个信息
		LocalDate ld2 = ld.withYear(2055); // 创建一个新对象返回，不会修改原对象
		System.out.println(ld);
		System.out.println(ld2);
		ld2 = ld.withDayOfMonth(30);

		// 把某个信息加多少
		LocalDate ld3 = ld.plusYears(2);
		ld3 = ld.plusMonths(1);

		// 把某个信息减多少
		LocalDate ld4 = ld.minusYears(2);
		ld4 = ld.minusMonths(1);

		// 获取指定日期的LocalDate对象
		LocalDate ld5 = LocalDate.of(2055, 12, 22);

		// 判断两个日期对象是否相等，在前还是在后
		ld4.equals(ld5);
		ld4.isAfter(ld5);
		ld4.isBefore(ld5);
	}

	// LocalTime
	// 表示时分秒
	// 用法和LocalDate几乎一样
	public static void test_LocalTime() {
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
	}

	// LocalDateTime
	// 包含日期和时间
	public static void test_LocalDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
	}

	// ZoneId: 时区
	public static void test_ZoneId() {
		// 获取系统默认时区
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

		// 获取Java支持的全部时区Id
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//		System.out.println(zoneIds);

		// 把某个时区id封装出zoneId对象
		ZoneId zone1 = ZoneId.of("America/New_York");
		System.out.println(zone1);

	}

	// ZoneDateTime 带时区的时间
	public static void test_ZoneDateTime() {
		ZoneId zone1 = ZoneId.of("America/New_York");
		System.out.println(zone1);

		// ZoneDateTime：带时区的时间
		// 获取某个时区的ZoneDateTime对象
		ZonedDateTime now = ZonedDateTime.now(zone1);
		System.out.println(now);

		// 获取世界标准时间
		ZonedDateTime now1 = ZonedDateTime.now(Clock.systemUTC());
		System.out.println(now1);
	}

	// Instant 时间线上的某个时刻
	public static void test_Instant() {
		Instant now = Instant.now();

		// 获取总秒数
		long seconds = now.getEpochSecond();
		System.out.println(seconds);

		// 不够一秒的纳秒数
		int nano = now.getNano();
		System.out.println(nano);

		// 加纳秒
		now.plusMillis(100);
		now.minusMillis(100);

		// 两个时间相等、在前、在后：equals, isBefore, isAfter
	}

	public static void main(String[] args) {
//		test_LocalDate();
//		test_ZoneId();
		test_ZoneDateTime();
	}

}
