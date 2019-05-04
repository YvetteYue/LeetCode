package TOP100_Liked_Problem.medium;

import java.util.PriorityQueue;
import java.util.Random;

public class NO215KthLargestElementinanArray {

//    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
//    not the kth distinct element.
//    Example 1:
//    Input: [3,2,1,5,6,4] and k = 2
//    Output: 5
//    Example 2:
//    Input: [3,2,3,1,2,4,5,5,6] and k = 4
//    Output: 4
//    Note:
//    You may assume k is always valid, 1 ≤ k ≤ array's length.

    public static void main(String[] args) {
        int nums[]={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }

    /*
    *
     * @Date 下午3:57 2019/2/12
     * 复杂度：
     * beats：70.49%
     **/
    public static  int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i:nums){
            if(priorityQueue.size()<k){
                priorityQueue.add(i);
            }else if(priorityQueue.peek()<i){
                priorityQueue.poll();
                priorityQueue.add(i);
            }
        }
        return priorityQueue.peek();
    }

    //TODO 堆排序 、quicksort快排

    /*
    *   quickselect 只排序包含k的分区
    *   一个优化是pivot用了random
     * @Date 下午6:53 2019/5/3
     * 复杂度：o(n)
     * beats：99%
     **/
    public int findKthLargest2(int[] nums, int k) {
        quicksort(nums,0,nums.length-1,k);
        return nums[k-1];
    }

    private void quicksort(int[] nums,int start,int end,int k){
        if(start>=end){
            return;
        }
        Random rand = new Random();
        int l=start,r=end;
        int index = rand.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        int tmp=nums[l];
        nums[l]=pivot;
        nums[index]=tmp;
        while(l<r){
            while(l<r&&pivot>=nums[r]){
                r--;
            }
            nums[l]=nums[r];
            while(l<r&&pivot<=nums[l]){
                l++;
            }
            nums[r]=nums[l];
        }
        nums[l]=pivot;
        if(l>=k)
            quicksort(nums,start,l-1,k);
        if(l+2<=k)
            quicksort(nums,l+1,end,k);
    }


    /*
    *   堆排序
     * @Date 下午9:39 2019/5/3
     * 复杂度：o(nlgn)
     * beats：99%
     **/
    public int findKthLargest3(int[] nums, int k) {
        int len=nums.length;
        for(int i=len/2-1;i>=0;i--){
            heapDownAdjust(nums,nums.length,i);

        }
        for(int i=len-1;i>len-k;i--){
            int tmp=nums[0];
            nums[0]=nums[i];
            nums[i]=tmp;
            heapDownAdjust(nums,i,0);
        }
        return nums[0];
    }


    private void heapDownAdjust(int[] arr,int length,int i){
        int temp = arr[i];
        //先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
}
