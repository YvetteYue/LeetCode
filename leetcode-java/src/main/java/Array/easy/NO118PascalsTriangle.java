package Array.easy;

import java.util.ArrayList;
import java.util.List;

public class NO118PascalsTriangle {
	/**
	 * 
	 *2018年4月22日 下午9:38:53
	 * beats:99.87%
	 * 复杂度：O(n^2)
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> alllist = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>();
			if (i == 0) {
				list.add(1);
				alllist.add(list);
			} else if (i == 1) {
				list.add(1);
				list.add(1);
				alllist.add(list);
			} else {
				list.add(1);
				for (int j = 1; j < i; j++) {
					List<Integer> tmplist = alllist.get(i - 1);
					list.add(tmplist.get(j - 1) + tmplist.get(j));
				}
				list.add(1);
				alllist.add(list);
			}
		}
		return alllist;
	}
}
