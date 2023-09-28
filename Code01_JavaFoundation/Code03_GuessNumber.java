package test;

import java.util.Scanner;

public class Code03_GuessNumber {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 1 + 1);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入您猜测的数据：");
			int guessNum = sc.nextInt();

			if (guessNum == num) {
				System.out.println("猜中了！");
				break;
			} else if (guessNum > num) {
				System.out.println("太大了！");
			} else {
				System.out.println("太小了！");
			}
		}
	}

}
