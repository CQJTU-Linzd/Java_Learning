package test.Code06_API;

import java.util.StringJoiner;

public class Code06_02_StringJoiner {

	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner("!"); // 指定拼接时的间隔符号
		sj.add("java1");
		sj.add("java2");
		System.out.println(sj);

		StringJoiner sj2 = new StringJoiner(", ", "[", "]"); // 间隔符号，开始符号，结束符号
		sj2.add("java1");
		sj2.add("java2");
		System.out.println(sj2);
	}

	// 传入一个数组，请打印成：[a, b, c] 的形式
	public static String getArrayData(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for (int num : arr) {
			sj.add(num + "");
		}
		return sj.toString();
	}

}
