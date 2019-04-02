package TOPInterviewQuestions.medium;

import java.util.ArrayList;
import java.util.List;

public class NO289GameofLife {


    //1.活的有小于两个活的 => 死
    //2.活的，有2或3，个活的 =》活
    //3.活的，有大于3个活的 =》死
    //4.死的，有3个活的 =》活
    public static void main(String[] args) {

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new NO289GameofLife().gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    *   模拟题
     * @Date 上午11:51 2019/3/15
     * 复杂度：
     * beats：100%
     **/
    public void gameOfLife(int[][] board) {
        List<Point> list=new ArrayList<>();
        int MaxX = board.length;
        int MaxY = board[0].length;
        for (int i = 0; i < MaxX; i++) {
            for (int j = 0; j < MaxY; j++) {
                int live = 0;
                int dies = 0;
                if (i > 0) {
                    if (board[i - 1][j] == 1) {
                        live++;    //上
                    } else dies++;
                    if (j > 0) {
                        if (board[i - 1][j - 1] == 1) {
                            live++; //左上
                        } else dies++;
                    }
                    if (j < MaxY - 1) {
                        if (board[i - 1][j + 1] == 1) {
                            live++;//右上
                        } else dies++;
                    }
                }
                if (j > 0) {
                    if (board[i][j - 1] == 1) {
                        live++;//左
                    } else dies++;
                }
                if (j < MaxY - 1) {
                    if (board[i][j + 1] == 1) {
                        live++;  //右
                    } else dies++;
                }
                if (i < MaxX - 1 && j > 0) {
                    if (board[i + 1][j - 1] == 1) {
                        live++; //左下
                    } else dies++;
                }
                if (i < MaxX - 1) {
                    if (board[i + 1][j] == 1) {
                        live++;
                    } else dies++;
                }
                if (i < MaxX - 1 && j < MaxY - 1) {
                    if (board[i + 1][j + 1] == 1) {
                        live++;
                    } else dies++;
                }
                if (board[i][j] == 1) {
                    if (live == 2 || live == 3) continue;
                    else if (live < 2||live > 3) {
//                       board[i][j]=0;
                        list.add(new Point(i,j,0));
                        // System.out.println("i" + i + "j" + j + "---------0");
                    }
                } else {
                    if (live == 3) {
//                        board[i][j]=1;
                        list.add(new Point(i,j,1));
                        // System.out.println("i" + i + "j" + j + "---------1");
                    }
                }
            }
        }
        for(Point point:list){
            board[point.x][point.y]=point.condition;
        }
    }

    class Point{
        int x,y,condition;
        Point(int x,int y,int condition){
            this.x=x;
            this.y=y;
            this.condition=condition;
        }
    }
}
