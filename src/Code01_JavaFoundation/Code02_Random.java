package test.Code01_JavaFoundation;

import java.util.Random;

public class Code02_Random {

	public static void main(String[] args) {
		// 使用Random生成随机数

		// 创建Random对象
		Random rd = new Random();
		// 调用Random的功能
		for (int i = 0; i < 20; i++) {
			int rand = rd.nextInt(10); // 0-9
			System.out.println(rand);
		}

		System.out.println("==========================");

		for (int i = 0; i < 20; i++) {
			System.out.println(randomNumber(4, 19));
		}

		System.out.println("==========================");

		int[] arr = randomArray(20, 4, 19);
		for (int num : arr) {
			System.out.println(num);
		}

		System.out.println("==========================");

		int[][] mat = randomMatrix(4, 5, 7, 25);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 生成[L...R]范围上的随机数
	public static int randomNumber(int L, int R) {
		return (int) (Math.random() * (R - L + 1) + L);
	}

	// 生成长度为n，数值范围在[L...R]上的随机数组
	public static int[] randomArray(int n, int L, int R) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * (R - L + 1) + L);
		}
		return arr;
	}

	// 生成大小为 n * m ，数值范围在[L...R]上的随机矩阵
	public static int[][] randomMatrix(int n, int m, int L, int R) {
		int[][] mat = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = (int) (Math.random() * (R - L + 1) + L);
			}
		}
		return mat;
	}

}
