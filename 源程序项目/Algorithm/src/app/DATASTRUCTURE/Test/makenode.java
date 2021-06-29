package app.DATASTRUCTURE.Test;

/**
 *@name makenode.java
 *@author 孔潇
 *@time 下午1:09:26
 *@description 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class makenode {
	public static List<node> make(String test) {
		Map<Character, node> map = new HashMap<Character, node>();
		char[] t = test.toCharArray();
		for (int i = 0; i < t.length; i++) {
			if (map.get(t[i]) == null) {
				node e = new node(t[i]);
				map.put(t[i], e);
			} else {
				node e = map.get(t[i]);
				e.add();
			}
		}
		List<node> list = new ArrayList<node>();
		for (Character s : map.keySet()) {
			list.add(map.get(s));
		}
		return list;

	}
}