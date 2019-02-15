package TOP100_Liked_Problem.medium;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class NO79WordSearch {

//    Given a 2D board and a word, find if the word exists in the grid.
//    The word can be constructed from letters of sequentially adjacent cell,
//    where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//        Example:
//    board =
//            [
//            ['A','B','C','E'],
//            ['S','F','C','S'],
//            ['A','D','E','E']
//            ]
//    Given word = "ABCCED", return true.
//    Given word = "SEE", return true.
//    Given word = "ABCB", return false.

    public static void main(String[] args) {
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new NO79WordSearch().exist(board,"BCCFC"));
    }

    /*
    *
     * @Date 上午11:14 2019/2/15
     * 复杂度：
     * beats：31.08%
     **/
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)return true;
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    vis=new int[board.length][board[0].length];
                    vis[i][j]=1;
                    flag=false;
                    dfs(board,word,0,i,j);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private int[][] vis;
    private int[] aX={0,0,1,-1};
    private int[] aY={1,-1,0,0};
    boolean flag=false;
    private void dfs(char[][] board,String word,int pos,int x,int y){
        if(flag)return;
        if(board[x][y]==word.charAt(pos)) {
            if(pos==word.length()-1){
                flag=true;
                return;
            }else{
                for (int i = 0; i < 4; i++) {
                    int tmpX = x + aX[i];
                    int tmpY = y + aY[i];
                    if (tmpX < 0 || tmpX >= board.length) continue;
                    if (tmpY < 0 || tmpY >= board[0].length) continue;
                    if(vis[tmpX][tmpY]==1)continue;
                    vis[tmpX][tmpY]=1;
                    dfs(board, word, pos + 1, tmpX, tmpY);
                    vis[tmpX][tmpY]=0;
                }
            }
        }
    }

    //TODO 非最优 dfs
}
