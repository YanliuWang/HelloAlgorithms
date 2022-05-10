import java.util.LinkedHashMap;

/**
 * LeetCode146
 * @author yanliu
 * @create 2022-05-10-10:51 AM
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        int val = cache.get(key);
        makeRecently(key);

        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache.size() == capacity) {
            int head = cache.keySet().iterator().next();
            cache.remove(head);
        }

        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int value = cache.get(key);

        cache.remove(key);
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
