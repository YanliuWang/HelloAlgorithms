import java.util.*;

/**
 * LeetCode381
 * @author yanliu
 * @create 2022-09-10-3:07 PM
 */
public class InsertDeleteGetRandomDuplicateAllowed {
    class RandomizedCollection {
        private Map<Integer, Set<Integer>> numToIdxes;
        private List<Integer> list;
        private Random rand;

        public RandomizedCollection() {
            numToIdxes = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (!numToIdxes.containsKey(val)) {
                numToIdxes.put(val, new LinkedHashSet<>());
            }

            list.add(val);
            numToIdxes.get(val).add(list.size() - 1);

            return numToIdxes.get(val).size() == 1;
        }

        public boolean remove(int val) {
            if (!numToIdxes.containsKey(val) || numToIdxes.get(val).size() == 0) {
                return false;
            }

            int removeIdx = numToIdxes.get(val).iterator().next();
            numToIdxes.get(val).remove(removeIdx);

            int last = list.get(list.size() - 1);
            list.set(removeIdx, last);
            numToIdxes.get(last).add(removeIdx);
            numToIdxes.get(last).remove(list.size() - 1);

            list.remove(list.size() - 1);

            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
