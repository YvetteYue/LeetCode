package BinarySearch.easy;

import java.util.Arrays;

public class NO167TwoSumIIInputarrayissorted {

	//在一堆数字中找出两个数字之和为target的值，并返回其index
	public static void main(String[] args) {
		int numbers[]={2,7,11,15};
		int target=9;
		int a[]=twoSum2(numbers, target);
		for(int t:a){
			System.out.println(t);
		}
	}

	/**
	 * 
	 *2018年4月22日 下午9:52:38
	 * beats:3%
	 * 复杂度：
	 * 暴力求解
	 */
	public static int[] twoSum1(int[] numbers, int target) {
		for(int i=0;i<numbers.length;i++){
			int t=target-numbers[i];
			int j=i+1;
				while(j<numbers.length&&numbers[j]<t){
					j++;
				}
				if(j<numbers.length&&t==numbers[j]){
					int a[]=new int[2];
					a[0]=i+1;a[1]=j+1;
					return a;
				}
		}
		return numbers;
	}
	
	/**
	 * 
	 *2018年4月22日 下午9:52:38
	 * beats:26.94%
	 * 复杂度：
	 * 二分查找
	 */
	public static int[] twoSum2(int[] numbers, int target) {
		int[] a=new int[2];
		for(int i=0;i<numbers.length;i++){
			int index=binarySearch(numbers, i+1, numbers.length, target-numbers[i]);
			if(index>i){
				a[0]=i+1;
				a[1]=index+1;
				return a;
			}
		}
		return numbers;
	}
	
	//TODO
	public static int binarySearch(int[] numbers,int lo,int hi,int target){
		while(1<hi-lo){
			int mi=(lo+hi)>>1;
			if(target<numbers[mi]){
				hi=mi;
			}else lo=mi;
		}
		return (target==lo)?lo:-1;
	}
}
