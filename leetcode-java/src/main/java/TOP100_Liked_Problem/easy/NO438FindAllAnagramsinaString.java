package TOP100_Liked_Problem.easy;

import java.util.ArrayList;
import java.util.List;

public class NO438FindAllAnagramsinaString {

    public static void main(String[] args) {

    }

    /*
    *   双指针
     * @Date 下午10:25 2019/4/28
     * 复杂度：o(n)
     * beats：97%
     **/
    public List<Integer> findAnagrams1(String s, String p) {
        int plen=s.length();
        int[] hash=new int[256];
        for(char ch:p.toCharArray()){
            hash[ch]++;
        }
        int left=0,right=0,len=s.length();
        int count=p.length();
        char[] sch=s.toCharArray();
        List<Integer> list=new ArrayList<>();
        while(right<len){
            if(hash[sch[right]]>=1)count--;
            hash[sch[right]]--;
            right++;
            if(count==0) list.add(left);
            if(right-left==p.length()){
                if(hash[sch[left]]>=0){
                    count++;
                }
                hash[sch[left]]++;
                left++;
            }
        }
        return list;
    }

    /*
    *   巧妙！双指针 滑动窗口
     * @Date 下午11:15 2019/4/28
     * 复杂度：o(n)
     * beats：99.63%
     **/
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int[] hash=new int[256];
        for(char ch:p.toCharArray()){
            hash[ch]++;
        }
        char[] sch=s.toCharArray();
        int l=0,r=0;
        while(r<s.length()){
            //存在的话那么hash值减小
            if(hash[sch[r]]>0){
                hash[sch[r]]--;
                r++;
            }else{
                //不在p里边的话那么l右移动
                hash[sch[l]]++;
                l++;
            }
            if(r-l==p.length()) list.add(l);
        }
        return list;
    }

}
