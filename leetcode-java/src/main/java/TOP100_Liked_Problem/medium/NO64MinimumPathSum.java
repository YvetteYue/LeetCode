package TOP100_Liked_Problem.medium;

public class NO64MinimumPathSum {


//    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//    Note: You can only move either down or right at any point in time.
//    Example:
//    Input:
//            [
//            [1,3,1],
//            [1,5,1],
//            [4,2,1]
//            ]
//    Output: 7
//    Explanation: Because the path 1→3→1→1→1 minimizes the sum.

    public static void main(String[] args) {

    }

    /*
    *   O(n^2)  result[i][j]=min{result[i-1][j],result[i][j-1]}
    *   动态规划
     * @Date 下午7:11 2019/3/14
     * 复杂度：
     * beats：93.53%
     **/
    public int minPathSum(int[][] grid) {
        int MaxX=grid.length;
        int MaxY=grid[0].length;
        int[][] result=new int[MaxX][MaxY];
        result[0][0]=grid[0][0];
        for(int j=1;j<MaxY;j++){
            result[0][j]=grid[0][j]+result[0][j-1];
        }
        for(int i=1;i<MaxX;i++){
            result[i][0]=grid[i][0]+result[i-1][0];
        }

        for(int i=1;i<MaxX;i++){
            for(int j=1;j<MaxY;j++){
                result[i][j]=Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
            }
        }
        return result[MaxX-1][MaxY-1];
    }


    /*
    *   dfs方式计算dp
     * @Date 下午12:49 2019/5/1
     * 复杂度：o(n^2)
     * beats：99.82%
     **/
    public int minPathSum1(int[][] grid) {
        int[][] cache=new int[grid.length][grid[0].length];
        return dfs(grid,cache,0,0);
    }

    private int dfs(int[][] grid,int[][] cache,int x,int y){
        if(x>=grid.length||x<0||y>=grid[0].length||y<0){    //超出界限都是最大值
            return Integer.MAX_VALUE;
        }
        if(x==grid.length-1&&y==grid[0].length-1)return grid[x][y];//在最终节点时才有值
        if(cache[x][y]!=0) return cache[x][y];
        int right=dfs(grid,cache,x+1,y);
        int down=dfs(grid,cache,x,y+1);
        cache[x][y]=grid[x][y]+Math.min(right,down);
        return cache[x][y];
    }
}
