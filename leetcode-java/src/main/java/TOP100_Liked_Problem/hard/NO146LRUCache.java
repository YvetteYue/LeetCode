package TOP100_Liked_Problem.hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NO146LRUCache {




    /*
    *       双向链表+map
     * @Date 上午12:24 2019/5/5
     * 复杂度：get o(1) set o(1)
     * beats：83%
     **/
    class LRUCache {


        private Map<Integer, Node> entry;
        private int capacity;
        private Node head;
        private Node tail;
        private int count;

        public LRUCache(int capacity) {
            this.entry = new HashMap<>();
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.pre = null;
            head.next = tail;
            tail.pre = head;
            tail.next = null;
            this.count = 0;
        }

        private void deleteNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(Node node) {
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }

        public int get(int key) {
            if (entry.containsKey(key)) {   //key 存在则删除节点移动到头部
                Node node = entry.get(key);
                int result = node.value;
                deleteNode(node);
                addToHead(node);
                return result;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (entry.get(key) != null) {       //key值已经存在要修改之后移动到头部
                Node node = entry.get(key);
                node.value = value;
                deleteNode(node);
                addToHead(node);
            } else {        //key值不存在
                Node node = new Node(key, value);
                entry.put(key, node);
                if (count < capacity) {       //未超过容量则直接添加
                    addToHead(node);
                    count++;
                } else {                //超过容量则删除尾部然后添加到头部
                    entry.remove(tail.pre.key);
                    deleteNode(tail.pre);
                    addToHead(node);
                }
            }
        }

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

    }


    /*
    *   直接继承linkedHashMap
     * @Date 上午12:25 2019/5/5
     * 复杂度：get set o(1)
     * beats：99%
     **/
    class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
