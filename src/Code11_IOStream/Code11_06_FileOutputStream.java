package test.Code11_IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Code11_06_FileOutputStream {

	// 文件字节输出流

	public static void main(String[] args) throws IOException {
//		OutputStream os = new FileOutputStream("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\out.txt");

		// 追加数据
		OutputStream os = new FileOutputStream("D:\\Eclipse\\javaspace\\test\\src\\test\\Code11_IOStream\\out.txt",
				true);

		// 写一个字节
		os.write(98);
		os.write('a');

		// 写入一个字节数组
		String str = "张三abc";
		byte[] bytes = str.getBytes();
		os.write(bytes);

		os.write(bytes, 0, 6); // 0位置开始，写6个字节

		// 换行符
		os.write("\r\n".getBytes());

		os.close();
	}

}
