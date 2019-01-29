/**
 * 
 */
package Array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yvette
 *
 */
public class NO414ThirdMaximumNumber {
	public static void main(String[] args) {
		int nums[] = {1,2,2,5,3,5};
		System.out.println(thirdMax(nums));
	}

	/**
	 * 暴力
	 *2018年5月14日 下午5:40:40
	 * beats:10%
	 * 复杂度：
	 */
	public static  int thirdMax(int[] nums) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			Collections.sort(list);
			if(list.contains(nums[i]))continue;
			if(list.size()<3){
				list.add(nums[i]);
				continue;
			}
			int min=list.get(0);
			if(min<nums[i]){
				list.remove(0);
				list.add(nums[i]);
			}
		}
		Collections.sort(list);
		if(list.size()<3){
			return list.get(list.size()-1);
		}
		return list.get(0);
	}
}
