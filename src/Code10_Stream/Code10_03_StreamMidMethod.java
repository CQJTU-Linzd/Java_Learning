package test.Code10_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Code10_03_StreamMidMethod {

	public static class Student {

		private String name;
		private int age;
		private double height;

		public Student(String name, int age, double height) {
			this.name = name;
			this.age = age;
			this.height = height;
		}

		@Override
		public int hashCode() {
			return Objects.hash(age, height, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return age == other.age && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
					&& Objects.equals(name, other.name);
		}
	}

	public static void main(String[] args) {
		List<Double> scores = new ArrayList<>();
		Collections.addAll(scores, 98.5, 90.0, 45.5, 67.8, 22.4, 60.1, 57.1);

		// 1. 找出分数大于等于60的数据，并升序输出
		scores.stream().filter(s -> s >= 60).sorted().forEach(s -> System.out.println(s));

		List<Student> stus = new ArrayList<>();
		Student s1 = new Student("张三", 18, 164.9);
		Student s2 = new Student("李四", 45, 168.9);
		Student s3 = new Student("王五", 26, 177.8);
		Student s4 = new Student("王五", 23, 169.1);
		Student s5 = new Student("俊凯", 19, 172.4);
		Student s6 = new Student("小苏", 25, 160.2);
		Collections.addAll(stus, s1, s2, s3, s4, s5, s6);

		System.out.println("----------------------------");

		// 2. 找出年龄大于等于21且小于等于30的人，并按年龄降序输出
		stus.stream().filter(s -> s.age >= 21 && s.age <= 30).sorted((Student o1, Student o2) -> {
			return o2.age - o1.age;
		}).forEach(s -> System.out.println(s.name + " " + s.age));

		System.out.println("----------------------------");

		// 3. 取出身高最高的前3名学生，并输出
		stus.stream().sorted((o1, o2) -> Double.compare(o2.height, o1.height)).limit(3)
				.forEach(s -> System.out.println(s.name + " " + s.height));

		System.out.println("----------------------------");

		// 4. 取出身高倒数的2名学生，并输出
		stus.stream().sorted((o1, o2) -> Double.compare(o2.height, o1.height)).skip(stus.size() - 2)
				.forEach(s -> System.out.println(s.name + " " + s.height));

		System.out.println("----------------------------");

		// 5. 找出身高超过168的学生名字，要求去除重复名字
		// distinct 去重复，自定义类型的对象，如果希望内容一样就认为重复，需要重写HashCode，equals方法
		stus.stream().filter(s -> s.height > 168).map(s -> s.name).distinct().forEach(s -> System.out.println(s));

	}

}
