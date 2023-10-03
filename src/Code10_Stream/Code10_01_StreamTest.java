package test.Code10_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Code10_01_StreamTest {

	public static void main(String[] args) {

		// 找出名字列表中长度为三个字，且姓张的人

		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list, "张三", "张无忌", "张三丰", "周芷若");

		// 常规方法
		ArrayList<String> res = new ArrayList<>();
		for (String name : list) {
			if (name.length() == 3 && name.charAt(0) == '张') {
				res.add(name);
			}
		}
		System.out.println(res);

		// 使用stream流解决
		List<String> res2 = list.stream().filter(s -> s.length() == 3).filter(s -> s.charAt(0) == '张')
				.collect(Collectors.toList());

		System.out.println(res2);
	}

}
