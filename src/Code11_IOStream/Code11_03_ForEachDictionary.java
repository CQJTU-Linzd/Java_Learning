package test.Code11_IOStream;

import java.io.File;

public class Code11_03_ForEachDictionary {

	public static void main(String[] args) {
		// 遍历文件夹

		// 获取指定目录下所有的一级文件名称到一个字符串数组中返回
		File f1 = new File("D:\\Work");
		String[] names = f1.list();
		for (String name : names) {
			System.out.println(name);
		}

		// 获取指定目录下所有的一级文件对象到一个文件对象数组中返回
		File[] files = f1.listFiles();
		for (File f : files) {
			System.out.println(f.getPath());
		}
	}

}
