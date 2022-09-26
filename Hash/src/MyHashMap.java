import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode706
 * @author yanliu
 * @create 2022-09-24-10:34 PM
 */

public class MyHashMap {
    class Pair<K, V> {
        public K key;
        public V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class Chain {
        private List<Pair<Integer, Integer>> chain;

        public Chain() {
            chain = new LinkedList<>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : chain) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }

            return -1;
        }

        public void put(Integer key, Integer value) {
            boolean isFound = false;

            for (Pair<Integer, Integer> pair : chain) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                chain.add(new Pair<>(key, value));
            }
        }

        public void remove(Integer key) {
            for (Pair pair : chain) {
                if (pair.key.equals(key)) {
                    chain.remove(pair);
                    break;
                }
            }
        }
    }

    private final int SIZE = 2048;
    private Chain[] buckets;

    public MyHashMap() {
        buckets = new Chain[SIZE];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Chain();
        }
    }

    public void put(int key, int value) {
        int hashKey = key % SIZE;

        buckets[hashKey].put(key, value);
    }

    public int get(int key) {
        int hashKey = key % SIZE;

        return buckets[hashKey].get(key);
    }

    public void remove(int key) {
        int hashKey = key % SIZE;

        buckets[hashKey].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
