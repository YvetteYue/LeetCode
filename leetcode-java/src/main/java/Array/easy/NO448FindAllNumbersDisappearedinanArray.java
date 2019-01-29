package Array.easy;

import java.util.ArrayList;
import java.util.List;

//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
//some elements appear twice and others appear once.
//Find all the elements of [1, n] inclusive that do not appear in this array.
//Could you do it without extra space and in O(n) runtime? 
//You may assume the returned list does not count as extra space.
public class NO448FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {
		int nums[]={1,2,3,3,4,4};
		System.out.println(findDisappearedNumbers(nums));
	}

	/**
	 * 将当前数字对应的数组的数字的数值改成负数，那么第二次迭代是正数的就是有问题的数据
	 *2018年4月22日 下午10:21:46
	 * beats:25%
	 * 复杂度：
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			int tmp=nums[i];
			if(tmp<0){
				tmp=-tmp;
			}
			if(nums[tmp-1]>0)
				nums[tmp-1]=-nums[tmp-1];
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				list.add(i+1);
			}
		}
		return list;
	}
}
