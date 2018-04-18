package Arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class NO119PascalsTriangleII {

	// Given an index k, return the kth row of the Pascal's triangle.
	// could you optimize your algorithm to use only O(k) extra space

	//beats 53%
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			list.add(1);
			if (i >= 2) {
				for (int j = i - 1; j >= 1; j--) {
					list.set(j, list.get(j - 1) + list.get(j));
				}
			}
		}
		return list;
	}
}
