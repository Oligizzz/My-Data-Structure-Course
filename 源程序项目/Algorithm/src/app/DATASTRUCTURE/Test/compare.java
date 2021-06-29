package app.DATASTRUCTURE.Test;

/**
 *@name compare.java
 *@author 孔潇
 *@time 下午1:09:52
 *@description 
 */

import java.util.Comparator;

public class compare implements Comparator<node> {

	@Override
	public int compare(node o1, node o2) {
		return o1.value - o2.value;
	}

}