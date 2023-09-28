package test.Code03_API;

import java.util.ArrayList;
import java.util.Scanner;

public class C03_ArrayListTest {

	// 菜品类
	public static class Food {
		private String name;
		private double price;
		private String desc;

		public Food() {
			name = "";
			price = 0;
			desc = "";
		}

		public Food(String name, double price, String desc) {
			this.name = name;
			this.price = price;
			this.desc = desc;
		}
	}

	// 菜品操作类 实现上架和浏览的功能
	public static class FoodOperator {
		private ArrayList<Food> foodList;

		public FoodOperator() {
			this.foodList = new ArrayList<>();
		}

		// 上架商品
		public void addFood() {
			Food newFood = new Food();
			Scanner sc = new Scanner(System.in);

			System.out.println("请输入菜品名称：");
			String name = sc.next();
			System.out.println("请输入菜品价格：");
			double price = sc.nextDouble();
			System.out.println("请输入菜品描述：");
			String desc = sc.next();

			newFood.name = name;
			newFood.price = price;
			newFood.desc = desc;

			this.foodList.add(newFood);
		}

		// 展示上架的菜品
		public void showAllFoods() {
			if (this.foodList.isEmpty()) {
				System.out.println("当前未添加菜品！");
				return;
			}
			for (Food f : foodList) {
				System.out.println("名称：" + f.name);
				System.out.println("价格：" + f.price);
				System.out.println("描述：" + f.desc);
				System.out.println("------------------------");
			}
		}

		// 负责展示操作界面
		public void start() {
			while (true) {
				System.out.println("请选择功能：");
				System.out.println("1. 上架菜品");
				System.out.println("2. 展示菜品");
				System.out.println("0. 退出界面");
				Scanner sc = new Scanner(System.in);
				String select = sc.next();
				switch (select) {
				case "1":
					addFood();
					break;
				case "2":
					showAllFoods();
					break;
				case "0":
					System.out.println("欢迎下次使用！");
					return;
				default:
					System.out.println("命令无效！");
				}
			}

		}
	}

	public static void main(String[] args) {
		// 完成商家菜品上架
		FoodOperator foodOp = new FoodOperator();
		foodOp.start();
	}

}
