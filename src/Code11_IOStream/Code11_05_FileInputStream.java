package test.Code11_IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Code11_05_FileInputStream {

	// FileInputStream：文件字节输入流
	// 把磁盘数据以内存形式读入到内存

	// 每次读取一个字节
	public static void readOneByte() throws IOException {
		InputStream is = new FileInputStream("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\test.txt");
//		int b = is.read();
//		System.out.println((char) b);

		// 使用循环重复读取
		int b = 0;
		while ((b = is.read()) != -1) {
			System.out.print((char) b);
		}

		is.close();
	}

	// 每次读取多个字节
	public static void readMultipleBytes() throws IOException {
		InputStream is = new FileInputStream("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\test.txt");
//		byte[] buf = new byte[3];
//		// len表示实际读到了几个字节
//		int len = is.read(buf);
//		String s = new String(buf);
//		System.out.println(s);

		// 使用循环重复读取
		byte[] buf = new byte[3];
		int len = 0;
		while ((len = is.read(buf)) != -1) {
			String s = new String(buf, 0, len);
			System.out.print(s);
		}

		is.close();
	}

	// 一次性读取完全部字节
	// 方式1：定义一个字节数组与被读文件一样大，一次性全部读完存到数组里
	public static void readAllBytes1() throws IOException {
		InputStream is = new FileInputStream("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\test.txt");

		File f = new File("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\test.txt");
		long size = f.length();

		byte[] buf = new byte[(int) size];
		// len表示实际读到了几个字节
		int len = is.read(buf);
		String s = new String(buf);
		System.out.println(s);
	}

	// 方式2：使用库函数readAllBytes()
	public static void readAllBytes2() throws IOException {
		InputStream is = new FileInputStream("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\test.txt");
		byte[] buf = is.readAllBytes();
		System.out.println(new String(buf));
	}

	public static void main(String[] args) throws IOException {
//		readOneByte();
//		readMultipleBytes();
//		readAllBytes1();
		readAllBytes2();
	}

}
