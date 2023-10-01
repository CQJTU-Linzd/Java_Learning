package test.Code08_Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Code08_02_ExceptionHandle {

	// 异常的处理

	// 方式一：记录异常并响应合适的信息给用户

	public static void test1() throws FileNotFoundException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse("2023-11-12 11:09:12");
		System.out.println(d);

		test2();
	}

	public static void test2() throws FileNotFoundException {
		// 读取文件
		InputStream is = new FileInputStream("D:/aaa.png");
	}

//	public static void main(String[] args) {
//	// 最外层调用者就不要再把异常抛出给上级了
//	try {
//		test1();
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		System.out.println("文件不存在");
//		e.printStackTrace();
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		System.out.println("要解析的时间有问题");
//		e.printStackTrace();
//	}
//}

	// 方式二：尝试重新修复

	public static double getMoney() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入合适的价格");
			double money = sc.nextDouble();
			if (money > 0) {
				return money;
			} else {
				System.out.println("您输入的价格有问题");
			}
		}
	}

	public static void main(String[] args) {
		while (true) {
			try {
				System.out.println(getMoney());
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("请您输入合法的价格");
				// e.printStackTrace();
			}
		}
	}

}
