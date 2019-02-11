package BinarySearch.easy;

public class NO852PeakIndexinaMountainArray {


//    Let's call an array A a mountain if the following properties hold:
//    A.length >= 3
//    There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//    Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
//    Example 1:
//    Input: [0,1,0]
//    Output: 1
//    Example 2:
//    Input: [0,2,1,0]
//    Output: 1
//    Note:
//            3 <= A.length <= 10000
//            0 <= A[i] <= 10^6
//    A is a mountain, as defined above.
    public static void main(String[] args) {

        int nums[]={0,1,2,0};
        System.out.println(peakIndexInMountainArray(nums));
    }

    /*
    *   A的长度大于等于3才可用，二分变体
     * @Date 下午6:28 2019/2/10
     * 复杂度：
     * beats：100.00%
     **/
    public static int peakIndexInMountainArray(int[] A) {
        int begin=0,end=A.length-1;
        while(begin<end){
            int mid=(begin+end)>>1;
            if(A[mid]<A[mid+1]){
                begin=mid;
            }else if(A[mid-1]>A[mid]){
                end=mid;
            }else return mid;
        }
        return 0;
    }

}
