package TOPInterviewQuestions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NO4544SumII {
//    Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
//    there are such that A[i] + B[j] + C[k] + D[l] is zero.
//    To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
//    All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
//    Example:
//    Input:
//    A = [ 1, 2]
//    B = [-2,-1]
//    C = [-1, 2]
//    D = [ 0, 2]
//    Output:
//            2
//    Explanation:
//    The two tuples are:
//            1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//            2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

    public static void main(String[] args) {
        int A[] = { -1,-1};
        int B[] = {-1,1};
        int C[] = {-1,1};
        int D[] = { 1,-1};
        System.out.println(fourSumCount2(A,B,C,D));
    }

    //  至少是o(n^2)
    /*
    *  超时了
     * @Date 下午4:43 2019/1/31
     * 复杂度：o(n^4)
     * beats：
     **/
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int sum=0;
        for(int a=0;a<A.length;a++){
            for(int b=0;b<B.length;b++){
                for(int c=0;c<C.length;c++){
                    for(int d=0;d<D.length;d++){
                        if(A[a]+B[b]+C[c]+D[d]==0){
                            sum++;
                        }
                    }
                }

            }
        }
        return sum;
    }

    /*
    * 使用map
     * @Date 上午11:57 2019/2/1
     * 复杂度：54%
     * beats：
     **/
    //        Map<Integer, Integer>map=new HashMap<>();
//        int sum=0,res=0;
//        for(int i=0;i<A.length;i++){
//            for(int j=0;j<B.length;j++){
//                sum=A[i]+B[j];
//                map.put(sum,map.getOrDefault(sum,0)+1);
//            }
//        }
//        for(int i=0;i<C.length;i++){
//            for(int j=0;j<D.length;j++){
//                res+=map.getOrDefault((-C[i]-D[j]),0);
//            }
//        }
//        return res;
    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int tmp=A[i]+B[j];
                if(map.containsKey(tmp)){
                    map.put(tmp,map.get(tmp)+1);
                }else{
                    map.put(tmp,1);
                }
            }
        }
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int tmp=C[i]+D[j];
                if(map.containsKey(-tmp)){
                    sum+=map.get(-tmp);
                }
            }
        }


        return sum;
    }

    /*
    *
     * @Date 上午10:44 2019/2/1
     * 复杂度：
     * beats：50.64%
     **/
    public static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int tmpAB[]=new int[A.length*B.length];
        int ablen=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                tmpAB[ablen]=A[i]+B[j];
                ablen++;
            }
        }

        int tmpCD[]=new int[C.length*D.length];
        int cdlen=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                tmpCD[cdlen]=C[i]+D[j];
                cdlen++;
            }
        }
        Arrays.sort(tmpAB);
        Arrays.sort(tmpCD);
        System.out.println();
        int sum=0;
        for(int i=0;i<tmpAB.length;i++){
            int pos1=binarySearch2(tmpCD,0,tmpCD.length,-tmpAB[i]);
            int pos2=binarySearch2(tmpCD,0,tmpCD.length,-tmpAB[i]-1);
            sum+=pos1-pos2;
        }
        return sum;
    }

    //有效查找区间缩短至1时算法才会终止
    public static int binarySearch(int[] nums,int lo,int hi,int ele){
        while(1<hi-lo){
            int mi=(lo+hi)>>1;
            if(ele<nums[mi]){//[lo,mi)或[mi,hi)
                hi=mi;
            }else lo=mi;
        }//出口时hi=lo+1,查找区间仅含一个元素A[lo]
        return (ele==nums[lo])?lo:-1;
    }

    //待查找区间缩短至0
    public static int binarySearch2(int[] nums,int lo,int hi,int ele){
        while(lo<hi){
            int mi=(lo+hi)>>1;
            if(ele<nums[mi]){//[lo,mi) 或（mi,hi）
                hi=mi;
            }else lo=mi+1;
        }//出口时，A[lo=hi] 为不大于e的最大元素
        return --lo;
    }

}
