package test.Code03_API;

public class C01_String {

	public static void main(String[] args) {
		String str = "abcdasd";
		char[] chs = str.toCharArray();

		String str2 = "aaabbb";
		boolean isEqual = str.equals(str2);
		System.out.println(isEqual);

		String substr = str.substring(0, 5); // [startIndex, endIndex)
		System.out.println(substr);

		String s3 = "1!2!78!2!95!";
		String[] ans = s3.split("!");
		for (String s : ans) {
			System.out.println(s);
		}
	}

}
