package TOP100_Liked_Problem.hard;

import java.util.Stack;

//TODO 数据方法
public class NO42TrappingRainWater {
    public static void main(String[] args) {

        int pos[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new NO42TrappingRainWater().trap(pos));
    }

    /*
    *   栈
     * @Date 下午1:38 2019/3/1
     * 复杂度：
     * beats：45.86%
     **/
    public int trap(int[] height) {
        if(height.length==0)return 0;
        int sum=0;
        Stack<Integer> stack=new Stack<>();
        int start=height[0];
        for(int i=0;i<height.length;i++){
            System.out.println(stack);
            if(stack.isEmpty()){
                start=height[i];
                stack.push(height[i]);
            }else{
                if(start>=height[i]){
                    stack.push(height[i]);
                }else{
                    while(!stack.isEmpty()){
                        sum+=(start-stack.pop());
                    }
                    start=height[i];
                    stack.push(height[i]);
                }
            }
        }
        start=stack.pop();
        while(!stack.isEmpty()){
            int tmp=stack.pop();
            if(start<tmp){
                start=tmp;
            }else{
                sum+=start-tmp;
            }
        }
        return sum;
    }
}
