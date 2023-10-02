package test.Code09_Containers;

import java.util.LinkedList;

public class Code09_01_LinkedList {

	public static void testList() {
		LinkedList<String> list = new LinkedList<>();

		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		System.out.println(list);

		list.add(2, "ddd");

		list.remove(1);

		list.get(0);

		list.set(0, "aaaa");

		list.addFirst("eee");

		list.addLast("fff");

		list.getFirst();

		list.getLast();

		list.removeFirst();

		list.removeLast();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
