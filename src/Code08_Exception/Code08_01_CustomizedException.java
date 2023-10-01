package test.Code08_Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Code08_01_CustomizedException {

	public static void test_Exception() throws ParseException { // 抛出异常
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 捕获异常
//		try {
		Date d = sdf.parse("2023-11-12 12:09:22");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// 自定义异常

	// 运行时异常类，必须继承RuntimeException
	public static class AgeIllegalRuntimeException extends RuntimeException {
		public AgeIllegalRuntimeException() {
			super();
		}

		public AgeIllegalRuntimeException(String message) {
			super(message);
		}
	}

	public static void checkAge(int age) {
		if (age > 0 && age < 120) {
			System.out.println("年龄符合！");
		} else {
			// 用一个异常对象封装这个问题
			throw new AgeIllegalRuntimeException("Age is illegal! Your age is " + age);
		}
	}

	// 编译时异常
	public static class AgeIllegalException extends Exception {
		public AgeIllegalException() {
			super();
		}

		public AgeIllegalException(String message) {
			super(message);
		}
	}

	public static void checkAge2(int age) throws AgeIllegalException {
		if (age > 0 && age < 120) {
			System.out.println("年龄符合！");
		} else {
			// 用一个异常对象封装这个问题
			throw new AgeIllegalException("Age is illegal! Your age is " + age);
		}
	}

	public static void main(String[] args) {
		// 运行时异常
		try {
			checkAge(160);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("底层出bug！");
		}

		// 编译时异常
		try {
			checkAge2(26);
		} catch (AgeIllegalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
