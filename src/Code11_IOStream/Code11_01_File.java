package test.Code11_IOStream;

import java.io.File;

public class Code11_01_File {

	public static void main(String[] args) {
		// 创建一个File文件，指代某个具体文件
		File f1 = new File("D:\\Work\\Linux");
		boolean e = f1.exists();
		System.out.println(e);
		// System.out.println(f1.getName());
		System.out.println(f1.length());

	}

}
