package test.Code06_MoreAPI;

import java.util.Arrays;

public class Code06_08_Lambda {

	public static class Student {
		private String name;
		private int age;
		private int height;

		Student() {
		}

		Student(String name, int height, int age) {
			this.name = name;
			this.age = age;
			this.height = height;
		}
	}

	public static void main(String[] args) {
		Student[] stus = new Student[4];
		stus[0] = new Student("张三", 168, 18);
		stus[1] = new Student("李四", 178, 21);
		stus[2] = new Student("王五", 164, 27);
		stus[3] = new Student("小苏", 180, 28);

		// Lambda
		Arrays.sort(stus, (Student s1, Student s2) -> {
			return s1.height - s2.height;
		});

		for (Student s : stus) {
			System.out.println(s.name + " " + s.height);
		}

		String[] strs = new String[4];
		strs[0] = "abcabc";
		strs[1] = "zeccd";
		strs[2] = "ffee";
		strs[3] = "gg";

		Arrays.sort(strs, (String a, String b) -> {
//			return a.compareToIgnoreCase(b);
			return a.charAt(0) - b.charAt(0);
		});
		for (String s : strs) {
			System.out.println(s);
		}
	}

}
