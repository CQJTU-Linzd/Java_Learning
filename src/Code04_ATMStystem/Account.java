package test.Code04_ATMStystem;

public class Account {
	private String cardId;
	private String name;
	private char sex;
	private String password;
	private double restMoney; // 账户余额
	private double limit; // 每次最大取现额度

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(double restMoney) {
		this.restMoney = restMoney;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}
}
