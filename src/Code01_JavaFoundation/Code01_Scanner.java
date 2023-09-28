package test.Code01_JavaFoundation;

// 导包
import java.util.Scanner;

public class Code01_Scanner {

	public static void main(String[] args) {
		// 创建一个键盘扫描器对象
		Scanner sc = new Scanner(System.in);
		// 调用sc的功能，来接收用户输入的数据
		System.out.println("请输入您的年龄：");
		int age = sc.nextInt();
		System.out.println("您的年龄为：" + age);

		System.out.println("请输入您的姓名：");
		String name = sc.next();
		System.out.println("您的姓名为：" + name);

	}

}
