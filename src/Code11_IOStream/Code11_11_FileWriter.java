package test.Code11_IOStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Code11_11_FileWriter {

	// 文件字符输出流

	public static void main(String[] args) {
		try (Writer fw = new FileWriter(
				"D:\\\\Eclipse\\\\javaspace\\\\test\\\\src\\\\test\\\\Code11_IOStream\\\\out.txt");) {
			// 写一个字符
			fw.write('a');
			fw.write('林');

			// 写一个字符串
			fw.write("李四bcd");

			// 写字符串的一部分出去
			fw.write("李四bcd", 0, 2); // 写两个字符

			// 写字符数组
			char[] buf = { 'a', 'b', 'c', '黑', '马' };

			fw.write(buf);

			fw.write(buf, 3, 2);

			// 换行
			fw.write("\r\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
