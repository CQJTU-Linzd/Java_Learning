package test.Code11_IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Code11_08_TryCatchFinally {

	public static void main(String[] args) {
		try {
			System.out.println(10 / 2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 代码无论正常执行，还是出现异常，都会执行的代码
			System.out.println("finally执行了一次");
		}
	}

	public static int divide(int a, int b) {
		try {
			return a / b;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			// 千万不要在finally中返回数据！
//			return 111;
		}
	}

	// 复制文件代码的改进

	public static void copyFile() {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("D:\\Work\\Linux\\shell.txt");
			os = new FileOutputStream("C:\\Users\\23004\\Desktop\\shell2.txt");
			// 创建字节数组，转移字节数据
			byte[] buf = new byte[2048];
			int len = 0;
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
