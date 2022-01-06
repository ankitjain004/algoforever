import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {

    HashMap<Integer, Integer> vals; //to store key value pair
    HashMap<Integer, Integer> counts; // to store key vs count
    HashMap<Integer, LinkedHashSet<Integer>> map;
    int min = -1;
    int max_capacity;

    public LFUCache(int capacity) {
        max_capacity = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        map = new HashMap<>();
        map.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;

        int count = counts.get(key);

        //updating counts map
        counts.put(key, count + 1);

        //remove this key from current count and add to count+1
        map.get(count).remove(key);
        if (count == min && map.get(count).size() == 0)
            min++;

        if (!map.containsKey(count + 1))
            map.put(count + 1, new LinkedHashSet<>());

        map.get(count + 1).add(key);

        return vals.get(key);

    }

    public void put(int key, int value) {
        //if key is present
        if (max_capacity <= 0) return;
        if (vals.containsKey(key)) {
            //update the corresponding value
            vals.put(key, value);
            int count = counts.get(key);
            //remove from count
            map.get(count).remove(key);
            if (count == min && map.get(count).size() == 0)
                min++;

            if (!map.containsKey(count + 1))
                map.put(count + 1, new LinkedHashSet<>());
            map.get(count + 1).add(key);

            counts.put(key, count + 1);

        } else {
            //if val is not present then 2 cases, either it is full or less than full
            //if it is full then remove the list count element
            if (vals.size() >= max_capacity) {
                int toRemove = map.get(min).iterator().next();
                map.get(min).remove(toRemove);
                vals.remove(toRemove);

            }

            //since we are entering a new value so min = 1;
            min = 1;

            map.get(min).add(key);
            counts.put(key, 1);
            vals.put(key, value);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */