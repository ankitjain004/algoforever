import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    static int fullCapacity;
    private HashMap<Integer, Integer> map = new HashMap<>();
    Deque<Integer> dq = new LinkedList<Integer>();

    public LRUCache(int capacity) {
        fullCapacity = capacity;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            dq.remove(key);
            dq.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            dq.remove(key);

            dq.addFirst(key);
            map.put(key, value);
        } else if (dq.size() == fullCapacity) {
            int element = dq.removeLast();
            map.remove(element);
            dq.addFirst(key);
            map.put(key, value);
        } else {
            dq.addFirst(key);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
//[[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache obj = new LRUCache(2);
        obj.put(1, 0);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));


    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

