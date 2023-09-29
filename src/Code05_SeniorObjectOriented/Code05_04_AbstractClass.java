package test.Code05_SeniorObjectOriented;

public class Code05_04_AbstractClass {

	// 抽象类 无法实例化对象
	public abstract static class A {
		public abstract void run(); // 抽象方法使用abstract修饰，不能有函数体
	}

	// for test

	public static abstract class Animal {

		private String name;

		public abstract void cry();

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static class Cat extends Animal {
		public void cry() {
			System.out.println("喵喵喵");
		}
	}

	public static class Dog extends Animal {
		public void cry() {
			System.out.println("汪汪汪");
		}
	}

	public static void main(String[] args) {
		Animal a = new Cat();
		a.cry();
		a = new Dog();
		a.cry();
	}

}
