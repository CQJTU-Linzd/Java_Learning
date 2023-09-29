package test.Code04_ATMStystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

	private ArrayList<Account> accounts;
	private Scanner sc;
	private Account curLoginAct; // 当前登录的账户

	public ATM() {
		this.accounts = new ArrayList<>();
		this.sc = new Scanner(System.in);
		this.curLoginAct = null;
	}

	// 欢迎界面
	public void showMenu() {
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
						this.curLoginAct = act;
						showUserMenu();
						return;
					} else {
						System.out.println("密码不正确，请重新输入！");
					}
				}
			} else {
				System.out.println("卡号不存在，请重新输入！");
			}
		}
	}

	// 展示登录后的操作界面
	private void showUserMenu() {
		while (true) {
			System.out.println("===========");
			System.out.println("用户：" + this.curLoginAct.getName() + "  请选择功能：");
			System.out.println("1. 查询账户");
			System.out.println("2. 存款");
			System.out.println("3. 取款");
			System.out.println("4. 转账");
			System.out.println("5. 修改密码");
			System.out.println("6. 退出");
			System.out.println("7. 注销账户");
			int select = sc.nextInt();
			switch (select) {
			case 1: // 展示当前登录的账户信息
				showCurLoginAccount();
				break;
			case 2: // 存款
				depositMoney();
				break;
			case 3: // 取款
				drawMoney();
				break;
			case 4: // 转账
				transferMoney();
				break;
			case 5: // 密码修改
				updatePassword();
				break;
			case 6:
				System.out.println("退出成功！");
				return;
			case 7: // 销户
				if (deleteAccount()) {
					return;
				}
				break;
			default:
				break;
			}
		}
	}

	// 展示当前登录的账户信息
	private void showCurLoginAccount() {
		System.out.println("=====当前账户信息如下=====");
		System.out.println("卡号：" + this.curLoginAct.getCardId());
		System.out.println("户主：" + this.curLoginAct.getName());
		System.out.println("余额：" + this.curLoginAct.getRestMoney());
		System.out.println("取现额度：" + this.curLoginAct.getLimit());
	}

	// 存款
	private void depositMoney() {
		System.out.println("=====存款操作=====");
		System.out.println("请输入存款金额");
		double money = sc.nextDouble();
		double restMoney = this.curLoginAct.getRestMoney();
		this.curLoginAct.setRestMoney(restMoney + money);
		System.out.println("存款成功！当前余额：" + this.curLoginAct.getRestMoney());
	}

	// 取款
	private void drawMoney() {
		System.out.println("=====取款操作=====");
		if (this.curLoginAct.getRestMoney() < 100) {
			System.out.println("余额不足100元，无法取款！");
			return;
		}
		while (true) {
			System.out.println("请输入取款金额");
			double money = sc.nextDouble();
			if (this.curLoginAct.getRestMoney() >= money) {
				if (money > this.curLoginAct.getLimit()) {
					System.out.println("当前取款金额超过了单次限额，限额为：" + this.curLoginAct.getLimit());
				} else {
					this.curLoginAct.setRestMoney(this.curLoginAct.getRestMoney() - money);
					System.out.println("取款成功！当前余额：" + this.curLoginAct.getRestMoney());
					break;
				}
			} else {
				System.out.println("余额不足，您的账户余额为：" + this.curLoginAct.getRestMoney());
			}
		}
	}

	// 转账
	private void transferMoney() {
		System.out.println("=====转账操作=====");
		if (this.accounts.size() < 2) {
			System.out.println("当前系统中无其他账户，无法转账！");
			return;
		}
		if (this.curLoginAct.getRestMoney() == 0) {
			System.out.println("您的账户余额为0，无法转账！");
			return;
		}
		while (true) {
			System.out.println("请输入对方的卡号：");
			String cardId = sc.next();
			Account act = this.containsAccount(cardId);
			if (act != null) {
				String name = "*" + act.getName().substring(1);
				System.out.println("您将要给：" + name + "转账，请输入该用户的姓氏：");
				String firstName = sc.next();
				if (act.getName().startsWith(firstName)) {
					while (true) {
						System.out.println("请输入要转账的金额：");
						double money = sc.nextDouble();
						if (this.curLoginAct.getRestMoney() >= money) {
							this.curLoginAct.setRestMoney(this.curLoginAct.getRestMoney() - money);
							act.setRestMoney(act.getRestMoney() + money);
							System.out.println("转账成功！当前账户余额：" + this.curLoginAct.getRestMoney());
							return;
						} else {
							System.out.println("您的余额不足，无法转账！最多可转：" + this.curLoginAct.getRestMoney());
						}
					}
				} else {
					System.out.println("姓氏输入有误！");
				}
			} else {
				System.out.println("该卡号不存在，请重新输入！");
			}
		}
	}

	// 修改密码
	private void updatePassword() {
		System.out.println("=====修改密码操作=====");
		while (true) {
			System.out.println("请输入原始密码：");
			String oldPwd = sc.next();
			if (oldPwd == this.curLoginAct.getPassword()) {
				while (true) {
					System.out.println("请输入新密码：");
					String newPwd = sc.next();
					System.out.println("请输入确认密码：");
					String checkPwd = sc.next();
					if (newPwd.equals(checkPwd)) {
						this.curLoginAct.setPassword(newPwd);
						System.out.println("修改密码成功！");
						return;
					} else {
						System.out.println("两次密码不一致，请重新输入！");
					}
				}
			} else {
				System.out.println("密码有误，请重新输入！");
			}
		}
	}

	// 销户
	private boolean deleteAccount() {
		System.out.println("=====销户操作=====");
		System.out.println("确定要销户？ y/n");
		String select = sc.next();
		if (select.equals("y")) {
			if (this.curLoginAct.getRestMoney() == 0) {
				this.accounts.remove(this.curLoginAct);
				this.curLoginAct = null;
				System.out.println("销户成功！");
				return true;
			} else {
				System.out.println("您的账户仍有余额，不允许销户！");
				return false;
			}
		} else {
			System.out.println("已取消销户！");
			return false;
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
		System.out.print("恭喜您：" + act.getName() + "，开户成功！");
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
