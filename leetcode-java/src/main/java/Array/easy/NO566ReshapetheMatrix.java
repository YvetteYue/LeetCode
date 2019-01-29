package Array.easy;

public class NO566ReshapetheMatrix {

	public static void main(String[] args) {
		int[][] nums={{1,2,3,4}};
		int[][] num2=matrixReshape(nums, 2, 3);
		int x=num2.length;
		int y=num2[0].length;
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){
				System.out.print(num2[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 *2018年4月22日 下午10:22:42
	 * beats:64%
	 * 复杂度：
	 */
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int x=nums.length;
		int y=nums[0].length;
		if(x*y!=r*c){
			return nums;
		}
		int[][] num2=new int[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				int a=i*c+j;
				num2[i][j]=nums[a/y][a%y];
			}
		}
		return num2;
	}
}
