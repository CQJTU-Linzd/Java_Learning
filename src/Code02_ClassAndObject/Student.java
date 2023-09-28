package test.Code02_ClassAndObject;

public class Student {
	String name;
	int chinese;
	int math;
	int english;

	Student() {
		this.chinese = 0;
		this.math = 0;
		this.english = 0;
		this.name = "";
	}

	Student(String name, int chn, int mat, int eng) {
		this.name = name;
		this.chinese = chn;
		this.math = mat;
		this.english = eng;
	}

	public void printTotalScore() {
		System.out.println("学生" + name + "的总成绩：" + (chinese + math + english));
	}

	public void printAverageScore() {
		System.out.println("学生" + name + "的平均成绩：" + (double) (chinese + math + english) / 3.0);
	}
}
