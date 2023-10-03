package test.Code10_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Code10_02_GetStream {

	public static void main(String[] args) {
		// 获取List集合的stream流
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "张三", "张无忌", "张三丰", "周芷若");
		Stream<String> streams1 = list.stream();

		// 获取Set集合的stream流
		Set<String> set = new HashSet<>();
		Collections.addAll(set, "张三", "张无忌", "张三丰", "周芷若");
		Stream<String> streams2 = set.stream();
		streams2.filter(s -> s.contains("张")).forEach(s -> System.out.println(s));

		// 获取Map集合的stream流
		Map<String, Integer> map = new HashMap<>();
		map.put("张三", 18);
		map.put("张无忌", 24);
		map.put("张三丰", 54);
		map.put("周芷若", 11);

		Set<String> keys = map.keySet();
		Stream<String> keyStream = keys.stream();

		Collection<Integer> values = map.values();
		Stream<Integer> valueStream = values.stream();

		// 键值对作为整体
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		Stream<Map.Entry<String, Integer>> kvStream = entries.stream();
		kvStream.filter(it -> it.getKey().contains("张"))
				.forEach(it -> System.out.println(it.getKey() + " " + it.getValue()));

		// 获取数组的stream流
		String[] names = { "张三", "张无忌", "张三丰", "周芷若" };
		Stream<String> streams3 = Arrays.stream(names);
		Stream<String> streams4 = Stream.of(names);

	}

}
