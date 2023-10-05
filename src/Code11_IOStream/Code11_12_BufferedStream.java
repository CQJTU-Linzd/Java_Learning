package test.Code11_IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class Code11_12_BufferedStream {

	public static void BufferedInputAndOutputStream() {
		try (InputStream is = new FileInputStream("D:\\Work\\Linux\\shell.txt");
				OutputStream os = new FileOutputStream("C:\\Users\\23004\\Desktop\\shell2.txt");
				// 定义一个字节缓冲输入流包装原始的字节输入流
				InputStream bis = new BufferedInputStream(is);
				OutputStream bos = new BufferedOutputStream(os);) {
			// 创建字节数组，转移字节数据
			byte[] buf = new byte[2048];

			int len = 0;
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void BufferedReaderAndWriter() {
		try (Reader fr = new FileReader("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\out.txt");
				// 创建一个字符缓冲输入流包装原始的字符输入流
				BufferedReader br = new BufferedReader(fr);

		) {

			// 每次读取多个字符
			char[] buf = new char[1];
			int len = 0;
			while ((len = br.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}

			// 按行读
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BufferedReaderAndWriter();
	}

}
