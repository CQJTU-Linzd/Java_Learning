package test.Code06_API;

public class Code06_01_StringBuilder_StringBuffer {

	// StringBuffer的接口和StringBuilder完全一样，但是StringBuffer线程安全，StringBuilder线程不安全

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("abcd");

		s.append('a');
		s.append("efg");
		System.out.println(s);

		// 反转
		s.reverse();
		System.out.println(s);

		// 长度
		System.out.println(s.length());

		// 转成String
		String str = s.toString();
	}

}
