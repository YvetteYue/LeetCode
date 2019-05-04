package TOP100_Liked_Problem.medium;


public class NO208ImplementTriePrefixTree {


    /*
    *
     * @Date 上午12:45 2019/5/5
     * 复杂度：o(n)
     * beats：99.82%
     **/
    class Trie {

        /**
         * Initialize your data structure here.
         */

        TrieNode head;

        public Trie() {
            head = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode tmp = head;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (tmp.next[chs[i] - 'a'] == null) {
                    tmp.next[chs[i] - 'a'] = new TrieNode();
                }
                tmp = tmp.next[chs[i] - 'a'];
            }
            tmp.isEnd=true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode tmp = head;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (tmp.next[chs[i] - 'a'] == null) {
                    return false;
                }
                tmp=tmp.next[chs[i]-'a'];
            }
            return tmp.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode tmp = head;
            char[] chs = prefix.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (tmp.next[chs[i] - 'a'] == null) {
                    return false;
                }
                tmp=tmp.next[chs[i]-'a'];
            }
            return true;
        }


        class TrieNode {
            TrieNode next[] = new TrieNode[26];
            boolean isEnd=false;
            TrieNode() {
            }
        }
    }
}
