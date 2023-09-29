package test.Code05_SeniorObjectOriented;

public class Code05_01_Inherit {

	public class A {
		public int a;

		public void print1() {
			System.out.println("print1");
		}

		private int b;

		private void print2() {
			System.out.println("print2");
		}
	}

	// B继承A
	public class B extends A {

		// B可以使用A中的非私有变量和函数
		public void print3() {
			System.out.println(a);
			print1();
		}
	}

	// 函数重写
	public class C extends A {
		public void print1() {
			System.out.println("printC");
		}
	}

}
