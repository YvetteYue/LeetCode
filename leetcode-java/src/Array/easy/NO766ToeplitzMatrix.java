package Array.easy;

public class NO766ToeplitzMatrix {
	//A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
	//Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
	//Toeplitz矩阵（diagonal-constant matrix），指矩阵中每条自左上至右下的斜线上的元素相同
	public static void main(String[] args) {
		//[[1,2,3,4],[5,1,2,3],[9,5,1,2]]
		int[][] matrix={{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.println(isToeplitzMatrix2(matrix));
	}
	
	/**
	 * 
	 *2018年4月22日 下午10:24:24
	 * beats:77%,空间局部性优化
	 * 复杂度：
	 */
	public static boolean isToeplitzMatrix2(int[][] matrix) {
		int y=matrix.length;
		int x=matrix[0].length;
		for(int i=1;i<y;i++){
			for(int j=1;j<x;j++){
				if(i>j){
					if(matrix[i][j]!=matrix[i-j][0]){
						return false;
					}
				}else{
					if(matrix[i][j]!=matrix[0][j-i]){
						return false;
					}
				}
			}
		}
		
		return true;
	}

	/**
	 * 
	 *2018年4月22日 下午10:24:34
	 * beats:3%
	 * 复杂度：
	 */
	public static boolean isToeplitzMatrix1(int[][] matrix) {
		int y=matrix.length;
		int x=matrix[0].length;
		System.out.println(y+"->"+x);
		for(int i=0;i<y;i++){
			int tmp1=matrix[i][0];
			int k=0;
			int t=i;
			while(t<y&&k<x){
				if(matrix[t][k]==tmp1){
					k++;
					t++;
				}else{
					return false;
				}
			}
		}
		for(int i=0;i<x;i++){
			int tmp1=matrix[0][i];
			int k=0;
			int t=i;
			while(k<y&&t<x){
				if(matrix[k][t]==tmp1){
					k++;
					t++;
				}else{
					return false;
				}
			}
		}
		return true;
	}
}