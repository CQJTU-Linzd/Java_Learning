package test.Code01_JavaFoundation;

import java.util.HashMap;

public class aa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

		int[] arr = { 1, 5, 4, 7, 9, 8 };
		System.out.println(process(arr, 0));

		HashMap<Integer, Integer> map = new HashMap();
		map.containsKey(arr[0]);
	}

	private static int[] tree = new int[10000];

	public static void test() {

	}

	public static int process(int[] arr, int i) {
		if (i >= arr.length) {
			return 0;
		}
		int p1 = process(arr, i + 1);
		int p2 = arr[i] + process(arr, i + 2);
		return Math.max(p1, p2);
	}

}
