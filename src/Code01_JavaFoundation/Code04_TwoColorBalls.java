package test.Code01_JavaFoundation;

import java.util.Scanner;

public class Code04_TwoColorBalls {

	// 实现双色球
	public static void main(String[] args) {
		// 接收用户投注的号码
		int[] userNumbers = userSelectNumbers();
		printArray(userNumbers);
		int[] luckyNumbers = createLuckNumbers();
		printArray(luckyNumbers);

		judge(userNumbers, luckyNumbers);
	}

	// 让用户投注一组号码并返回（前6个是红球号码，最后一个是蓝球号码），
	public static int[] userSelectNumbers() {
		int[] nums = new int[7];
		Scanner sc = new Scanner(System.in);
		// 遍历前6个位置，让用户依次投注红球号码
		for (int i = 0; i < nums.length - 1; i++) {
			// 号码在1-33之间，不能重复
			while (true) {
				System.out.println("请输入第" + (i + 1) + "个红球号码(号码在1-33之间，不能重复)：");
				int num = sc.nextInt();
				if (num < 1 || num > 33) {
					System.out.println("号码不在指定范围(1-33)内！");
				} else if (exist(nums, num)) {
					System.out.println("号码重复！");
				} else {
					nums[i] = num;
					break;
				}
			}
		}
		// 最后一个蓝球号码
		while (true) {
			System.out.println("请输入最后一个蓝球号码(号码在1-16之间)：");
			int last = sc.nextInt();
			if (last < 1 || last > 16) {
				System.out.println("号码不在指定范围(1-16)内！");
			} else {
				nums[nums.length - 1] = last;
				break;
			}
		}
		return nums;
	}

	// 随机生成一组中奖号码
	public static int[] createLuckNumbers() {
		int[] nums = new int[7];
		int num = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			do {
				num = (int) (Math.random() * (33) + 1);
			} while (exist(nums, num));
			nums[i] = num;
		}
		do {
			num = (int) (Math.random() * (16) + 1);
		} while (exist(nums, num));
		nums[nums.length - 1] = num;
		return nums;
	}

	// 判断命中情况和是否中奖
	public static void judge(int[] userNums, int[] luckyNums) {
		int redCount = 0, blueCount = 0;
		for (int i = 0; i < userNums.length - 1; i++) {
			for (int j = 0; j < luckyNums.length - 1; j++) {
				if (luckyNums[j] == userNums[i]) {
					redCount++;
					break;
				}
			}
		}
		blueCount = userNums[userNums.length - 1] == luckyNums[luckyNums.length - 1] ? 1 : 0;
		System.out.println("您命中的红球数量：" + redCount);
		System.out.println("您命中的蓝球数量：" + blueCount);
		if (redCount == 6 && blueCount == 1) {
			System.out.println("一等奖！奖金1000万元！");
		} else if (redCount == 6 && blueCount == 0) {
			System.out.println("二等奖！奖金500万元！");
		} else if (redCount == 5 && blueCount == 1) {
			System.out.println("三等奖！奖金100万元！");
		} else if (redCount == 5 && blueCount == 0) {
			System.out.println("四等奖！奖50万元！");
		} else if (redCount == 4 && blueCount == 1) {
			System.out.println("五等奖！奖金10万元！");
		} else if (redCount == 4 && blueCount == 0) {
			System.out.println("六等奖！奖金1万元！");
		} else {
			System.out.println("很遗憾！您未中奖！");
		}
	}

	private static boolean exist(int[] arr, int x) {
		for (int num : arr) {
			if (num == x) {
				return true;
			}
		}
		return false;
	}

	private static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
