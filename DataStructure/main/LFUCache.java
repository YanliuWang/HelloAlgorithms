import java.util.HashMap;
import java.util.LinkedHashSet;

/**实现 least Recently Used 缓存淘汰机制
 * @author yanliu
 * @create 2020-12-31-10:13
 */
public class LFUCache {
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFreq;
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    private int minFreq;
    private int cap;

    public LFUCache(int cap) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
        this.cap = cap;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        increaseFreqOf(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreqOf(key);
            return;
        }

        if (this.cap == keyToVal.size()) {
            removeMinFreq();
        }

        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        this.minFreq = 1;
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // delete the first element of the list
        int deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);

        // remove the keyList if it is empty
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }

        // refresh the KF and KV map
        keyToFreq.remove(deleteKey);
        keyToVal.remove(deleteKey);

    }


    /**
     * increase the frequency of key
     * @param key
     */
    private void increaseFreqOf(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        // remove key from freqToKeys map
        freqToKeys.get(freq).remove(key);

        // put the new frequency to the freqToKeys map if absent
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq).add(key);

        // remove the linked hashset if it is empty
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);

            // refresh the minFreq if necessary
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }
}
