/**
 * 
 */
package Array.easy;

public class NO88MergeSortedArray  
{
//     Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3
// Output: [1,2,2,3,5,6]
	public static void main (String[] args) 
	{
	   int[] nums1={1,2,3,0,0,0};
	   int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
	}
	//2018/05/12 17:33
	//99%
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n-1;
        int a=m-1;
        int b=n-1;
        while(len>=0){
            while((b>=0&&a>=0&&nums1[a]>=nums2[b])||(a>=0&&b<0)){
                nums1[len]=nums1[a];
                len--;
                a--;
                
            }
            while((b>=0&&a>=0&&nums1[a]<=nums2[b])||(a<0&&b>=0)){
                nums1[len]=nums2[b];
                len--;
                b--;
               
            }
        }
    }
	
}
