package test.Code06_MoreAPI;

import java.util.Arrays;
import java.util.Comparator;

public class Code06_07_Comparator {

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
		// TODO Auto-generated method stub

		Student[] stus = new Student[4];
		stus[0] = new Student("张三", 168, 18);
		stus[1] = new Student("李四", 178, 21);
		stus[2] = new Student("王五", 164, 27);
		stus[3] = new Student("小苏", 180, 28);

		// 自定义比较器
		Arrays.sort(stus, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.height - o2.height;
			}
		});

		for (Student s : stus) {
			System.out.println(s.name + " " + s.height);
		}
	}

}
