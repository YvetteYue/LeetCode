package TOP100_Liked_Problem.hard;

public class NO4MedianofTwoSortedArrays {

    public static void main(String[] args) {

        int num1[]={2,3};
        int num2[]={};
        System.out.println(new NO4MedianofTwoSortedArrays().findMedianSortedArrays(num1,num2));
    }

    /*
    *   两个指针的做法，类似于归并
     * @Date 下午5:08 2019/2/26
     * 复杂度：
     * beats：99.99%
     **/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len= nums1.length+nums2.length;
        if(len==0) return 0;
        int mid=len/2-1;
        int tmp1=0,tmp2=0;
        int i=0;
        int result1=0,result2=0;
        boolean flag=false;
        while(i<=mid){
            while(i<=mid&&tmp1==nums1.length&&tmp2<nums2.length){
                if(i==mid){
                    result1=nums2[tmp2];
                }
                tmp2++;
                i++;
            }
            while(i<=mid&&tmp2==nums2.length&&tmp1<nums1.length){
                if(i==mid){
                    result1=nums1[tmp1];
                }
                tmp1++;
                i++;
            }
            if(i<=mid&&tmp1<nums1.length&&tmp2<nums2.length&&nums1[tmp1]<=nums2[tmp2]){
                if(i==mid){
                    result1=nums1[tmp1];
                }
                tmp1++;
                i++;
            }else if(i<=mid&&tmp1<nums1.length&&tmp2<nums2.length&&nums1[tmp1]>=nums2[tmp2]){
                if(i==mid){
                    result1=nums2[tmp2];
                    flag=true;
                }
                tmp2++;
                i++;
            }
        }
//        System.out.println(result1);
        if(tmp1== nums1.length){
            result2=nums2[tmp2];
        }else if(tmp2== nums2.length){
            result2=nums1[tmp1];
        }else{
            result2=(nums1[tmp1]>nums2[tmp2])?nums2[tmp2]:nums1[tmp1];
        }
        if(len%2==0){
            return (result1+result2)/2.0;
        }else return result2*1.0;
    }


    //TODO 二分、递归的做法
}
