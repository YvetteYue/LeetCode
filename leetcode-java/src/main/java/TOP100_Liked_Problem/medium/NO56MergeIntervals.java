package TOP100_Liked_Problem.medium;

import bean.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NO56MergeIntervals {
//    Given a collection of intervals, merge all overlapping intervals.
//    Example 1:
//    Input: [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//    Example 2:
//    Input: [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

    public static void main(String[] args) {
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        System.out.println(merge(list));
    }


    /*
    *   sort+判断
     * @Date 上午11:56 2019/2/11
     * 复杂度：o(nlgn)
     * beats：92.57%
     **/
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }else return o1.start-o2.start;
            }
        });
        List<Interval> list=new ArrayList<>();
        for(Interval interval:intervals){
            if(list.size()==0) list.add(interval);
            else {
                Interval preInterval=list.get(list.size()-1);
                if(preInterval.end<interval.start){
                    list.add(interval);
                }else if(preInterval.end<interval.end){
                    preInterval.end=interval.end;
                }
            }
        }
        return list;
    }
}
