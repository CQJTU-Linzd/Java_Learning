package test.Code11_IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Code11_09_TryWithResource {

	public static void main(String[] args) {
		// 把要用到的资源放到小括号里，系统会自动释放
		// 只能用资源对象（资源都会实现AutoCloseable接口）
		try (InputStream is = new FileInputStream("D:\\Work\\Linux\\shell.txt");
				OutputStream os = new FileOutputStream("C:\\Users\\23004\\Desktop\\shell2.txt");) {
			// 创建字节数组，转移字节数据
			byte[] buf = new byte[2048];
			int len = 0;
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
