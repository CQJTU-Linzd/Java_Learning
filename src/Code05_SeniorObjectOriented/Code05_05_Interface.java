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

	public static void main(String[] args) {
		D d = new D();
		d.test1();
	}

}
