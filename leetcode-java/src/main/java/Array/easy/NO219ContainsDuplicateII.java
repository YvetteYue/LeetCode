/**
 * 
 */
package Array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Yvette
 *
 */
public class NO219ContainsDuplicateII {

	public static void main(String[] args) {
		int nums[]={1,2,1};
		System.out.println(containsNearbyDuplicate3(nums, 1));
	}
	
	/**
	 * 用List
	 * 超时！Time Limit Exceeded
	 *2018年5月10日 下午10:52:27
	 * beats:
	 * 复杂度：
	 */
	public static  boolean containsNearbyDuplicate(int[] nums, int k) {
		List<Integer> list=new ArrayList<>();
		if(k==0)return false;
		for(int i=0;i<nums.length;i++){
			if(i<k){
				if(list.contains(nums[i])){
					return true;
				}
				list.add(nums[i]);
			}else{
				System.out.println(list);
				if(list.contains(nums[i])){
					return true;
				}
				list.remove(Integer.valueOf(nums[i-k]));
				list.add(nums[i]);
			}
		}
		return false;
	}
	
	/**
	 * 使用map
	 *2018年5月10日 下午10:53:15
	 * beats:43.67%
	 * 复杂度：
	 */
	public static  boolean containsNearbyDuplicate2(int[] nums, int k) {
		//k=0时可以直接返回
		if(k==0)return false;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				//如果差小于k，那么符合条件，否则更新i值
				if(i-map.get(nums[i])<=k){
					return true;
				}else map.put(nums[i], i);
			}else map.put(nums[i],i);
		}
		return false;
	}
	
	/**
	 * 使用list
	 *2018年5月10日 下午11:15:16
	 * beats:95.33%
	 * 复杂度：
	 */
	public static  boolean containsNearbyDuplicate3(int[] nums, int k) {
		if(k==0||nums.length<=1)return false;
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<nums.length;i++){
			if(i>k){
//				能remove说明前面没有重的！
				set.remove(nums[i-k-1]);
			}
			if(!set.add(nums[i])){
				return true;
			}
		}
		return false;
	}
}
