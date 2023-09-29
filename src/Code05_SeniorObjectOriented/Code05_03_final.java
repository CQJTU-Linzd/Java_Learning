package test.Code05_SeniorObjectOriented;

public class Code05_03_final {

	// final 修饰 类，这个类不能被继承
	final class A {
	}
	// class B extends A {}

	// final 修饰 函数，该函数不能被重写
	public class C {
		public final void test() {

		}
	}

	public class D extends C {
//		public void test() {
//			
//		}
	}

	public static final String SCHOOL_NAME = "重庆交通大学"; // 当作宏来用

	public static void main(String[] args) {
		// final 修饰 变量，该变量只能赋值一次
		final int a = 10;
		// a = 20;

		// final 修饰 数组
		final int[] arr = { 1, 2, 3 };
		// arr = null;
		arr[1] = 20;
	}

}
