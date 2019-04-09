package TOP100_Liked_Problem.medium;

public class NO62UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths3(7,3));
    }

    /*
    * 递归简单版
     * @Date 下午4:40 2019/2/1
     * 复杂度：
     * beats：1.20%
     **/
    public static int uniquePaths(int m, int n) {
        if(m==1) return 1;
        if(n==1) return 1;
        if(n==2&&m==2) return 2;
        return uniquePaths(m,n-1)+uniquePaths(m-1,n);
    }



    /*
    *   dp
     * @Date 下午4:42 2019/2/1
     * 复杂度：
     * beats：100%
     **/
    public static int uniquePaths2(int m, int n) {
        int path[][]=new int[m][n];
        for(int i=0;i<n;i++){
            path[0][i]=1;
        }
        for(int i=0;i<m;i++){
            path[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                path[i][j]=path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }

    /*
    * dp 滚动数组
     * @Date 下午4:49 2019/2/1
     * 复杂度：
     * beats：
     **/
    public static int uniquePaths3(int m, int n) {
        int path[]=new int[n];
        for(int i=0;i<n;i++){
            path[i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++) {
                path[j] += path[j-1];
            }
        }
        return path[n-1];
    }

}
