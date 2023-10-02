package test.Code09_Containers;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Code09_02_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 3);
		map.put(2, 4);
		map.put(3, 5);

		// 遍历方式
		for (int key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}

		for (Entry e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

		TreeMap<Integer, Integer> tMap = new TreeMap<>();

	}

}
