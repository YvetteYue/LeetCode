package TOP100_Liked_Problem.medium;

import java.util.*;

public class NO49GroupAnagrams {

    /*
    *   字符串排序+hashmap
     * @Date 下午4:06 2019/4/21
     * 复杂度：o(nklong(k))
     * beats：99%
     **/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> list=new HashMap<>();
        for(String str:strs){
            char[] chs=str.toCharArray();
            Arrays.sort(chs);
            String key=String.valueOf(chs);
            if(!list.containsKey(key)){
                list.put(key,new ArrayList<>());
            }
            list.get(key).add(str);
        }
        return new ArrayList(list.values());
    }


    /*
    *   用26位字符数组 代替排序
     * @Date 下午4:09 2019/4/21
     * 复杂度：o(n*k)
     * beats：40%
     **/
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /*
    *   用26个奇数乘积判断
     * @Date 下午4:11 2019/4/21
     * 复杂度：
     * beats：
     **/
    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) key *= prime[c - 'a'];

            List<String> list;
            if (hashMap.containsKey(key)) {
                // hashMap.get(key) returns the index of the t where it's supposed to be added in the result;
                list = result.get(hashMap.get(key));
            } else {
                hashMap.put(key, result.size());
                list = new ArrayList<>();
                result.add(list);
            }
            list.add(s);
        }
        return result;
    }

}
