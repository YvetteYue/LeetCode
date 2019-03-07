public class test {

    public static void main(String[] args) {

        int[]nums={2,4,3,1,5,6,4};
        quicksort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static void quicksort(int[] nums,int low,int high){
        if(high-low<1)return;
        int pivot=partiton(nums,low,high);
        quicksort(nums,low,pivot-1);
        quicksort(nums,pivot+1,high);
    }

    private static int partiton(int[] nums,int low,int high){
        System.out.println(low+"->"+high);
        int tmp=nums[low];
        while(low<high){
            while(low<high&&tmp<nums[high]) --high;
            nums[low]=nums[high];
            while(low<high&&tmp>=nums[low]) ++low;
            nums[high]=nums[low];
        }
        nums[low]=tmp;
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"->");
        }
        System.out.println();
        return low;
    }

}
