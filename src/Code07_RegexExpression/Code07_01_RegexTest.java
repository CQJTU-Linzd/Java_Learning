package test.Code07_RegexExpression;

public class Code07_01_RegexTest {

	// 校验qq号是否正确，要求全部是数字，长度在6-20之间，不能以0开头

	public static boolean check1(String num) {
		if (num == null || num.length() < 6 || num.length() > 20 || num.charAt(0) == '0') {
			return false;
		}
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	// 正则
	public static boolean check2(String num) {
		return num != null && num.matches("[1-9]\\d{5,19}");
	}

	public static void main(String[] args) {
		System.out.println(check1("2178809878"));
		System.out.println(check1("0178809878"));
		System.out.println(check1("2178809a78"));
		System.out.println("---------------");
		System.out.println(check2("2178809878"));
		System.out.println(check2("0178809878"));
		System.out.println(check2("2178809a78"));
	}

}
