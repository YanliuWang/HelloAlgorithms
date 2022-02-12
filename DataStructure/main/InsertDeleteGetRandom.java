import java.util.*;

/**
 * LintCode 657 · Insert Delete GetRandom O(1)
 * @author yanliu
 * @create 2021-08-12-12:41
 */
public class InsertDeleteGetRandom {
    public class RandomizedSet {
        private List<Integer> array;
        private Random rand;
        private Map<Integer, Integer> numToIndex;


        public RandomizedSet() {
            // do intialization if necessary
            array = new ArrayList<>();
            numToIndex = new HashMap<>();
            rand = new Random();
        }

        /*
         * @param val: a value to the set
         * @return: true if the set did not already contain the specified element or false
         */
        public boolean insert(int val) {
            // write your code here
            // the set already contains the element
            if (numToIndex.containsKey(val)) {
                return false;
            }

            array.add(val);
            numToIndex.put(val, array.size() - 1);

            return true;
        }

        /*
         * @param val: a value from the set
         * @return: true if the set contained the specified element or false
         */
        public boolean remove(int val) {
            // write your code here
            if (!numToIndex.containsKey(val)) {
                return false;
            }

            int deleteNumIdx = numToIndex.get(val);

            // if the element is at the middle of list
            if (deleteNumIdx < array.size() - 1) {
                int last = array.get(array.size() - 1);
                array.set(deleteNumIdx, last);
                numToIndex.put(last, deleteNumIdx);
            }

            numToIndex.remove(val);
            array.remove(array.size() - 1);

            return true;
        }

        /*
         * @return: Get a random element from the set
         */
        public int getRandom() {
            // write your code here
            return array.get(rand.nextInt(array.size()));
        }
    }
}
