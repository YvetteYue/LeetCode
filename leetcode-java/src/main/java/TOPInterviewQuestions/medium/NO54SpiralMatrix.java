package TOPInterviewQuestions.medium;

import java.util.ArrayList;
import java.util.List;

public class NO54SpiralMatrix {

//    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//    Example 1:
//    Input:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    Output: [1,2,3,6,9,8,7,4,5]
//    Example 2:
//    Input:
//            [
//            [1, 2, 3, 4],
//            [5, 6, 7, 8],
//            [9,10,11,12]
//            ]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    public static void main(String[] args) {
        int[][] matrix={
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        System.out.println(spiralOrder(matrix));
    }

    /*
    *
     * @Date 下午4:01 2019/2/11
     * 复杂度：
     * beats：100.00%
     **/
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int maxX=matrix.length;
        if(maxX==0) return list;
        int maxY=matrix[0].length;
        int vis[][]=new int[maxX][maxY];
        int x=0,y=0;
        list.add(matrix[0][0]);
        vis[0][0]=1;
        while(x<maxX&&x>=0&&y<maxY&&y>=0){
            if(x-1>=0&&vis[x-1][y]==0){     //向上 x-
                while(x-1>=0&&vis[x-1][y]==0){
                    x--;
                    vis[x][y]=1;
                    list.add(matrix[x][y]);
                }
            }else if(y+1<maxY&&vis[x][y+1]==0){ //向右 y+

                while(y+1<maxY&&vis[x][y+1]==0){
                    y++;
                    vis[x][y]=1;
                    list.add(matrix[x][y]);
                }
            }else if(x+1<maxX&&vis[x+1][y]==0){  //向下 x+
                while(x+1<maxX&&vis[x+1][y]==0){
                    x++;
                    vis[x][y]=1;
                    list.add(matrix[x][y]);
                }
            }else if(y-1>=0&&vis[x][y-1]==0){//向左 y--

                while(y-1>=0&&vis[x][y-1]==0){
                    y--;
                    vis[x][y]=1;
                    list.add(matrix[x][y]);
                }
            }else{
                break;
            }
        }
        return list;
    }


}
