package test.Code02_ClassAndObject;

public class StudentTest {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "张三";
		stu.chinese = 70;
		stu.english = 70;
		stu.math = 70;
		stu.printTotalScore();
		stu.printAverageScore();
	}
}
