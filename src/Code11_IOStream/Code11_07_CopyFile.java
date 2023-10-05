package test.Code11_IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Code11_07_CopyFile {

	// 文件的复制

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("D:\\Work\\Linux\\shell.txt");
		OutputStream os = new FileOutputStream("C:\\Users\\23004\\Desktop\\shell2.txt");

		// 创建字节数组，转移字节数据
		byte[] buf = new byte[2048];

		int len = 0;
		while ((len = is.read(buf)) != -1) {
			os.write(buf, 0, len);
		}

		os.close();
		is.close();
	}

}
