package test.Code05_SeniorObjectOriented;

public class Code05_05_Interface {

	// 创建接口 接口不能创建对象
	public static interface A {
		// 接口内的成员变量默认都是常量
		String SCHOOL_NAME = "重庆交通大学";

		// 接口内的成员方法默认都是抽象方法
		void test1();
	}

	public static interface B {
		String SCHOOL_NAME = "重庆交通大学";

		void test2();
	}

	public static interface C {
		String SCHOOL_NAME = "重庆交通大学";

		void test3();
	}

	// 实现类
	// 要实现接口中的全部抽象方法
	public static class D implements A, B, C {

		@Override
		public void test3() {
			// TODO Auto-generated method stub

		}

		@Override
		public void test2() {
			// TODO Auto-generated method stub

		}

		@Override
		public void test1() {
			// TODO Auto-generated method stub

		}

	}

	// JDK8新增的3种接口方法

	public static interface E {
		// 1. 默认方法，必须使用default修饰，默认会被public修饰
		public default void test1() {
			System.out.println("默认方法");
			test2();
		}

		// 2. 私有方法，必须使用private修饰
		private void test2() {
			System.out.println("私有方法");
		}

		// 3. 静态方法，必须使用static修饰，默认会被public修饰
		static void test3() {
			System.out.println("静态方法");
		}

	}

	public static class F implements E {

	}

	public static void main(String[] args) {
		D d = new D();
		d.test1();

		F f = new F();
		f.test1();

		E.test3();
	}

}
