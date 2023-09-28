package test.Code04_ATMStystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

	private ArrayList<Account> accounts;
	private Scanner sc;

	public ATM() {
		this.accounts = new ArrayList<>();
		this.sc = new Scanner(System.in);
	}

	// 欢迎界面
	public void printMenu() {
		while (true) {
			System.out.println("欢迎进入黑马银行ATM系统！");
			System.out.println("1. 用户登录");
			System.out.println("2. 用户开户");
			System.out.println("请输入您的选择：");
			String select = sc.next();
			switch (select) {
			case "1":
				loginAccount();
				break;
			case "2":
				createAccount();
				break;
			default:
				System.out.println("输入无效，请重新选择！");
				break;
			}
		}
	}

	// 登录操作
	private void loginAccount() {
		if (this.accounts.isEmpty()) {
			System.out.println("当前系统没有账户！");
			return;
		}
		while (true) {
			System.out.println("请输入登录卡号");
			String cardId = sc.next();
			Account act = containsAccount(cardId);
			if (act != null) {
				while (true) {
					System.out.println("请输入登录密码：");
					String password = sc.next();
					if (act.getPassword().equals(password)) { // 密码正确
						System.out.println("登录成功！");
						break;
					} else {
						System.out.println("密码不正确，请重新输入！");
					}
				}
				break;
			} else {
				System.out.println("卡号不存在，请重新输入！");
			}
		}

	}

	// 开户操作
	private void createAccount() {
		Account act = new Account();
		System.out.println("请输入账户名称：");
		String name = sc.next();
		act.setName(name);
		while (true) {
			System.out.println("请输入性别：");
			char sex = sc.next().charAt(0);
			if (sex == '男' || sex == '女') {
				act.setSex(sex);
				break;
			} else {
				System.out.println("性别输入有误，请重新输入！");
			}
		}
		while (true) {
			System.out.println("请输入账户密码：");
			String password = sc.next();
			System.out.println("请输入确认密码：");
			String check = sc.next();
			if (password.equals(check)) {
				act.setPassword(password);
				break;
			} else {
				System.out.println("两次输入的密码不一致，请重新输入！");
			}
		}
		System.out.println("请输入取现额度：");
		double limit = sc.nextDouble();
		act.setLimit(limit);
		// 生成一个卡号，不能重复
		String cardId = createCardId();
		act.setCardId(cardId);
		// 新账户加到列表中
		this.accounts.add(act);
		System.out.print("恭喜您：" + act.getName() + (act.getSex() == '男' ? "先生" : "女士") + "，开户成功！");
		System.out.println("您的卡号为：" + cardId);
	}

	private String createCardId() {
		String cardId = "";
		do {
			cardId = "";
			for (int i = 0; i < 8; i++) {
				cardId += (int) (Math.random() * 10);
			}
		} while (containsAccount(cardId) != null);
		return cardId;
	}

	private Account containsAccount(String cardId) {
		for (Account act : this.accounts) {
			if (act.getCardId().equals(cardId)) {
				return act;
			}
		}
		return null;
	}

}
