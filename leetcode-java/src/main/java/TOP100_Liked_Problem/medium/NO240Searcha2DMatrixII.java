package TOP100_Liked_Problem.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NO240Searcha2DMatrixII {


//    Write an efficient algorithm that searches for a value in an m x n matrix.
//    This matrix has the following properties:
//    Integers in each row are sorted in ascending from left to right.
//    Integers in each column are sorted in ascending from top to bottom.
//    Example:
//    Consider the following matrix:
//            [
//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],
//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]
//            ]
//    Given target = 5, return true.
//    Given target = 20, return false.

    public static void main(String[] args) {
        int matrix[][]={
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new NO240Searcha2DMatrixII().searchMatrix(matrix,15));
    }

    /*
    *
     * @Date 下午2:55 2019/2/17
     * 复杂度：
     * beats：23.01%
     **/
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int pos1=binarysearch(matrix,matrix[0].length-1,0, matrix.length,target-1);    //右边最小
        int pos2=binarysearch(matrix,0,0,matrix.length,target);//左边最大
        if(pos2<0||pos1>=matrix.length-1) return false;
        for(int i=pos1+1;i<=pos2;i++){
            int result= Arrays.binarySearch(matrix[i],target);
            if(result>=0)return true;
        }
        return false;
    }

    private int binarysearch(int matrix[][],int pos,int l,int r ,int target){
        while(l<r){
            int mid=(l+r)>>1;
            if(matrix[mid][pos]>target){  //[l,m)(m,r)
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return --l;
    }


    //TODO 最优解
    /*
    *
     * @Date 下午3:06 2019/2/17
     * 复杂度：
     * beats：96.89%
     **/
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
