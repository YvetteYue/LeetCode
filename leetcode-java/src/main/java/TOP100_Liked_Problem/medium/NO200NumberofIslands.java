package TOP100_Liked_Problem.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NO200NumberofIslands {

//    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//    You may assume all four edges of the grid are all surrounded by water.
//    Example 1:
//    Input:
//            11110
//            11010
//            11000
//            00000
//    Output: 1
//    Example 2:
//    Input:
//            11000
//            11000
//            00100
//            00011
//    Output: 3

    public static void main(String[] args) {
        char grid[][]={
                {'1','1','0','0','0'},
                {'1','1','1','0','0'},
                {'0','0','1','1','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new NO200NumberofIslands().numIslands(grid));
    }


    /*
    *   bfs
     * @Date 下午1:39 2019/2/14
     * 复杂度：
     * beats：5.55%
     **/
    public int numIslands(char[][] grid) {
        if(grid.length==0)return 0;
        int pos[][]={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Point> queue=new LinkedList<>();
        int result=0;
        int xLen=grid.length;
        int yLen=grid[0].length;
        while(true) {
            Point start=null;
            Boolean flag=false;
            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    if (grid[i][j] == '1') {
                        start = new Point(i, j);
                        grid[i][j]='0';
                        flag=true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (start != null)
                queue.offer(start);
            else return result;
            while (!queue.isEmpty()) {
                Point point=queue.poll();
                for(int i=0;i<4;i++){
                    int x=point.x+pos[i][0];
                    int y=point.y+pos[i][1];
                    if(x<0||x>=xLen) continue;
                    if(y<0||y>=yLen) continue;
                    if(grid[x][y]=='1'){
                        grid[x][y]='0';
                        queue.offer(new Point(x,y));
                    }
                }
            }
            result++;
        }
    }
    class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    //TODO dfs 并查集
}
