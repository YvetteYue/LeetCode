package TOPInterviewQuestions.medium;

public class NO73SetMatrixZeroes {


    public static void main(String[] args) {
        int matrix[][]={
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        new NO73SetMatrixZeroes().setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /*
    *
     * @Date 下午1:15 2019/3/15
     * 复杂度：空间复杂度o(m+n)
     * beats：95.96%
     **/
    public void setZeroes(int[][] matrix) {
        int PosX[]=new int[matrix.length];
        int PosY[]=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    PosX[i]=1;
                    PosY[j]=1;
                }
            }
        }
        for(int i=0;i<PosX.length;i++){
            if(PosX[i]==1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<PosY.length;i++){
            if(PosY[i]==1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }


    //TODO o(1)的空间复杂度
}
