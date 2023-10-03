package test.Code10_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class Code10_04_StreamEndMethod {

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
		List<Student> stus = new ArrayList<>();
		Student s1 = new Student("张三", 18, 164.9);
		Student s2 = new Student("李四", 45, 168.9);
		Student s3 = new Student("王五", 27, 177.4);
		Student s4 = new Student("王五", 23, 169.1);
		Student s5 = new Student("俊凯", 19, 172.4);
		Student s6 = new Student("小苏", 25, 160.2);
		Collections.addAll(stus, s1, s2, s3, s4, s5, s6);

		// 1. 请统计身高超过168的学生有几人
		long cnt = stus.stream().filter(s -> s.height > 168).count();
		System.out.println(cnt);

		System.out.println("----------------------------");

		// 2. 找出身高最高的学生对象
		Student s = stus.stream().max((o1, o2) -> Double.compare(o1.height, o2.height)).get();
		System.out.println(s.name + " " + s.height);

		System.out.println("----------------------------");

		// 3. 找出身高超过165的学生，放到一个新列表中返回
		List<Student> list = stus.stream().filter(o -> o.height > 165).collect(Collectors.toList());
		for (Student ss : list) {
			System.out.println(ss.name + " " + ss.height);
		}

		System.out.println("----------------------------");

		// 4. 找出身高超过170的学生，放到一个新Map中返回
		Map<String, Double> map = stus.stream().filter(o -> o.height > 170).distinct()
				.collect(Collectors.toMap(a -> a.name, b -> b.height));
		for (Entry e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

}
