package test.Code05_SeniorObjectOriented;

import java.util.ArrayList;

public class Code05_07_Template {

	// 模板
	public static class MyArrayList<E> {
		private Object[] arr = new Object[10];
		private int size = 0;

		public boolean add(E e) {
			arr[size++] = e;
			return true;
		}

		public E get(int index) {
			return (E) arr[index];
		}
	}

	// 传进来的必须是Animal类型或者是它的子类
	public static class MyClass<E extends Animal> {

	}

	public static class Animal {
	}

	// 泛型接口
	// 系统需要处理学生和老师的数据，需要提供两个功能：
	// 保存查询数据
	// 根据名称查询数据

	public static class Teacher {
	}

	public static class Student {
	}

	public static interface Data<T> {
		void add(T t);

		ArrayList<T> queryByName(String name);
	}

	// 该接口都将对老师对象进行处理
	public static class TeacherData implements Data<Teacher> {
		public void add(Teacher teacher) {

		}

		public ArrayList<Teacher> queryByName(String name) {
			return null;
		}
	}

	// 该接口都将对学生对象进行处理
	public static class StudentData implements Data<Student> {
		public void add(Student student) {

		}

		public ArrayList<Student> queryByName(String name) {
			return null;
		}
	}

	// 泛型方法
	public static <T> void process1(T t) {

	}

	public static <T> T process2(T t) {
		return t;
	}

	public static void main(String[] args) {

	}

}
