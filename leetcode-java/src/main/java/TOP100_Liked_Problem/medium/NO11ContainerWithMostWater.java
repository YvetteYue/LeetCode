package TOP100_Liked_Problem.medium;

public class NO11ContainerWithMostWater {

    //TODO 思路需要再理解
//    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
//    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
//    which together with x-axis forms a container, such that the container contains the most water.
//            Note: You may not slant the container and n is at least 2.
//    The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
//    In this case, the max area of water (blue section) the container can contain is 49.
//    Example:
//    Input: [1,8,6,2,5,4,8,3,7]
//    Output: 49

    public static void main(String[] args) {
        int nums[]={1,8,6,2,5,4,8,3,7};
        System.out.println(new NO11ContainerWithMostWater().maxArea(nums));
    }

    /*
    *
     * @Date 下午12:31 2019/2/16
     * 复杂度：o(n^2)
     * beats：27.51%
     **/
    public int maxArea(int[] height) {
        int max=0;
        for(int i=0;i<height.length;i++){
            for(int j=0;j<i;j++){
                int tmp=Math.min(height[i],height[j])*(i-j);
                if(max<=tmp){
                    max=tmp;
                }
            }
        }
        return max;
    }
//      思路
//    The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.
//    All other containers are less wide and thus would need a higher water level in order to hold more water.
//    The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.
    /*
    *  思路：1.最长的可能是最优，高度最高的也可能是最优，那么没有长的高就可以被淘汰。
    *
    *https://leetcode.com/problems/container-with-most-water/solution/
     * @Date 下午12:31 2019/2/16
     * 复杂度：O(n)
     * beats：87.03%
     **/
    public int maxArea2(int[] height) {
        int water=0,i=0,j=height.length-1;
        while(i<j){
            water=Math.max(water, Math.min(height[i],height[j])*(i-j));
            //长度最长的情况下，选高度最高的
            if(height[i]<height[j]){    //如果左右某个小，那么可以往里边找高度够的，可能是最优。
                i++;
            }else j--;
        }
        return water;
    }

    /*
    *
     * @Date 下午12:57 2019/2/16
     * 复杂度：
     * beats：98.97%
     **/
    public int maxArea3(int[] height) {
        int water=0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            water = Math.max(water, (j - i) * h);
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return water;
    }

}
