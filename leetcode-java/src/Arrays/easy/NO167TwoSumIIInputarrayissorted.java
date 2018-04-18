package Arrays.easy;

public class NO167TwoSumIIInputarrayissorted {

	public static void main(String[] args) {
		int numbers[]={0,0,3,4};
		int target=0;
		int a[]=twoSum(numbers, target);
		for(int t:a){
			System.out.println(t);
		}
		
	}

	//beats 3%
	public static int[] twoSum(int[] numbers, int target) {
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
}
