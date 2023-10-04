package test.Code11_IOStream;

import java.io.File;
import java.io.IOException;

public class Code11_02_CreateAndDelete {

	public static void main(String[] args) throws IOException {
		// 创建文件
		File f1 = new File("C:\\Users\\23004\\Desktop\\abc.txt");
		f1.createNewFile();

		// 创建文件夹 只能创建一级文件夹
		File f2 = new File("C:\\Users\\23004\\Desktop\\aaa\\bbb\\ccc");
		f2.mkdir(); // 只能创建到aaa文件夹

		// 创建多级文件夹
		File f3 = new File("C:\\Users\\23004\\Desktop\\aaa\\bbb\\ccc");
		f3.mkdir(); // 只能创建到aaa文件夹

		// 删除文件或空文件，不能删除非空文件夹
		f1.delete();
	}

}
