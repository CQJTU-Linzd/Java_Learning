package test.Code05_SeniorObjectOriented;

public class Code05_06_AnonymousInnerClass {

	// 匿名内部类
	// 不需要为这个类起名字

//	new 类或接口(参数值...) {
//		类体(一般是方法重写)
//	};

	public static abstract class Animal {
		public abstract void cry();
	}

	public static void main(String[] args) {
		// 创建一个临时子类对象出来
		Animal a = new Animal() {
			public void cry() {
				System.out.println("猫喵喵叫");
			}
		};
		a.cry();
	}

}
