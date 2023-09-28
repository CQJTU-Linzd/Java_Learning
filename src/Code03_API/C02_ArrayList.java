package test.Code03_API;

import java.util.ArrayList;

public class C02_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		arr.add(18);
		arr.add(54);
		arr.add(2, 44); // 2下标插入元素

		int i = arr.get(2);
		int size = arr.size();
		arr.remove(0);
		arr.set(1, 55);
	}

}
