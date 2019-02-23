package TOP100_Liked_Problem.medium;



import bean.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NO341FlattenNestedListIterator {

    public static void main(String[] args) {

    }


}

/*
*
 * @Date 上午11:41 2019/2/19
 * 复杂度：
 * beats：25.29%
 **/
 class NestedIterator implements Iterator<Integer> {

     Stack<List<NestedInteger>> stack=new Stack<>();
     public NestedIterator(List<NestedInteger> nestedList) {
         stack.push(nestedList);
     }

     @Override
     public Integer next() {
         while(!stack.isEmpty()) {
             List<NestedInteger> list = stack.pop();
             while (!stack.isEmpty()&&list.size() == 0) {
                 list = stack.pop();
             }
             if(list.size()==0) return null;
             if(list.get(0).isInteger()){
                 NestedInteger num=list.remove(0);
                 stack.push(list);
                 return num.getInteger();
             }else{
                 NestedInteger num=list.remove(0);
                 stack.push(list);
                 stack.push(num.getList());
             }
         }
         return null;
     }

     @Override
     public boolean hasNext() {
         while(!stack.isEmpty()) {
             List<NestedInteger> list = stack.pop();
             while (!stack.isEmpty()&&list.size() == 0) {
                 list = stack.pop();
             }
             if(list.size()==0) return false;
             if(list.get(0).isInteger()){
                 stack.push(list);
                 return true;
             }else{
                 NestedInteger num=list.remove(0);
                 stack.push(list);
                 stack.push(num.getList());
             }
         }
         return false;
     }



     //TODO 不会写！！！ 最优解 使用迭代器，使用栈
    /*
    *
     * @Date 上午11:43 2019/2/19
     * 复杂度：
     * beats：74.90%
     **/
    public class NestedIterator2 implements Iterator<Integer> {

        List<Integer> list;
        Iterator<Integer> iterator;
        public NestedIterator2(List<NestedInteger> nestedList) {
            list =new ArrayList<>();
            flatten(nestedList, list);
            iterator = list.iterator();
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void flatten(List<NestedInteger> nestedList, List<Integer> list) {
            for(NestedInteger n : nestedList) {
                if(n.isInteger()) list.add(n.getInteger());
                else flatten(n.getList(), list);
            }
        }
    }

}