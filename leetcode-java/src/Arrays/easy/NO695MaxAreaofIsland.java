package Arrays.easy;

public class NO695MaxAreaofIsland {

	static int x[][]={{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		int a[][]={
		 {0,0,1,0,0,0,0,1,0,0,0,0,0},
		 {0,0,0,0,0,0,0,1,1,1,0,0,0},
		 {0,1,1,0,1,0,0,0,0,0,0,0,0},
		 {0,1,0,0,1,1,0,0,1,0,1,0,0},
		 {0,1,0,0,1,1,0,0,1,1,1,0,0},
		 {0,0,0,0,0,0,0,0,0,0,1,0,0},
		 {0,0,0,0,0,0,0,1,1,1,0,0,0},
		 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		int a[][]={{0,0,0,0,0,0,0,0}};
		System.out.println(x.length+"->"+x[0].length);
		System.out.println(maxAreaOfIsland(a));
	}

	/**
	 * 
	 *2018年4月22日 下午10:23:44
	 * beats:19%
	 * 复杂度：
	 */
	public static int maxAreaOfIsland(int[][] grid) {
		int max=0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==0)continue;
				grid[i][j]=0;
				int tmp=dfs(grid,i,j)+1;
				if(tmp>max) max=tmp;
			}
		}
		return max;
	}

	
	private static int dfs(int[][] grid, int i, int j) {
		int testmp=0;
		for(int k=0;k<4;k++){
			if((i+x[k][0]<0)||(i+x[k][0]>=grid.length)||(j+x[k][1]<0)||(j+x[k][1]>=grid[0].length)||grid[i+x[k][0]][j+x[k][1]]==0) 
				continue;
				testmp+=1;
				grid[i+x[k][0]][j+x[k][1]]=0;
				testmp+=dfs(grid,i+x[k][0],j+x[k][1]);
		}
		return testmp;
	}

	
}
