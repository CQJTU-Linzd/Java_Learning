package test.Code06_MoreAPI;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Code06_03_BigDecimal {

	// BigDecimal 解决小数运算失真的问题

	public static void main(String[] args) {
		double a = 0.1;
		double b = 0.2;
		System.out.println(a + b);
		System.out.println("--------------");

		// 把小数转成字符串，再封装成BigDecimal
//		BigDecimal a1 = new BigDecimal(Double.toString(a));
//		BigDecimal b1 = new BigDecimal(Double.toString(b));
		BigDecimal a1 = BigDecimal.valueOf(a);
		BigDecimal b1 = BigDecimal.valueOf(b);
		BigDecimal c1 = a1.add(b1);
		BigDecimal c2 = a1.subtract(b1);
		BigDecimal c3 = a1.multiply(b1);
		BigDecimal c4 = a1.divide(b1);
		BigDecimal c5 = a1.divide(b1, 2, RoundingMode.HALF_UP); // 保留两位，四舍五入
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
	}

}
