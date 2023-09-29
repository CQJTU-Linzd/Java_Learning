package test.Code05_SeniorObjectOriented;

public class Code05_02_PolyMorphic {

	// 父类
	public static class People {
		public void run() {
			System.out.println("人可以跑");
		}
	}

	public static class Student extends People {
		public void run() {
			System.out.println("学生可以跑");
		}
	}

	public static class Teacher extends People {
		public void run() {
			System.out.println("老师可以跑");
		}
	}

	public static void main(String[] args) {
		// 对象多态
		People p1 = new Student();
		// 行为多态
		p1.run();

		People p2 = new Teacher();
		p2.run();

		// 强制类型转换
		// Student p3 = (Student) (p1); // 正常
		// Teacher p4 = (Teacher) (p1); // 崩溃

		if (p1 instanceof Student) { // 判断变量的真实类型
			Student p3 = (Student) p1;
		} else {
			Teacher p4 = (Teacher) p1;
		}
	}

}
