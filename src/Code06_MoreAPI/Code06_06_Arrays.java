package test.Code06_MoreAPI;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

public class Code06_06_Arrays {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };

		// toString 返回数组内容
		System.out.println(Arrays.toString(arr));

		// copyOfRange(arr, startIndex, endIndex)
		int[] subArr = Arrays.copyOfRange(arr, 1, 4);
		System.out.println(Arrays.toString(subArr));

		// copyOf(arr, int newLength) 拷贝数组，可以指定新数组的长度
		int[] arr2 = Arrays.copyOf(arr, 10);
		System.out.println(Arrays.toString(arr2));

		// setAll 把数组中的原数据改为新数据再存进去
		// 把所有价格都打八折
		double[] prices = { 88.9, 40.1, 33.2 };
		Arrays.setAll(prices, new IntToDoubleFunction() {
			@Override
			public double applyAsDouble(int value) {
				// TODO Auto-generated method stub
				return prices[value] * 0.8;
			}
		});
		System.out.println(Arrays.toString(prices));

		// sort
		Arrays.sort(arr);
	}

}
