package test.Code11_IOStream;

import java.io.FileReader;
import java.io.Reader;

public class Code11_10_FileReader {

	// 文件字符输入流

	public static void main(String[] args) {
		try (Reader fr = new FileReader("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\out.txt");) {
			// 每次读取一个字符
//			int ch = 0;
//			while ((ch = fr.read()) != -1) {
//				System.out.print((char) ch);
//			}

			// 每次读取多个字符
			char[] buf = new char[1];
			int len = 0;
			while ((len = fr.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
