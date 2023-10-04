package test.Code11_IOStream;

import java.io.File;

public class Code11_04_SearchFile {

	public static void main(String[] args) {
		// 文件搜索
		// 在D盘中搜索“shell.txt”文件，并输出路径
		searchFile(new File("D:\\Work"), "shell.txt");
	}

	public static void searchFile(File dir, String fileName) {
		if (dir == null || !dir.exists() || dir.isFile()) {
			return;
		}
		// 当前目录下的一级文件对象
		File[] files = dir.listFiles();
		// 判断当前目录下是否存在一级文件对象，以及是否可以拿到一级文件对象
		if (files != null && files.length > 0) {
			for (File f : files) {
				if (f.isFile()) {
					if (f.getName().equals(fileName)) {
						System.out.println("找到了：" + f.getAbsolutePath());
					}
				} else {
					searchFile(f, fileName);
				}
			}
		}
	}

}
