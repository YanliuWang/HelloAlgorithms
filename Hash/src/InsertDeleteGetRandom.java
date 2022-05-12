import java.util.*;

/**
 * LeetCode380
 * @author yanliu
 * @create 2022-05-12-9:50 AM
 */
public class InsertDeleteGetRandom {
    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> numToIdx;

        public RandomizedSet() {
            nums = new ArrayList<>();
            numToIdx = new HashMap<>();
        }

        public boolean insert(int val) {
            if (numToIdx.containsKey(val)) {
                return false;
            }

            numToIdx.put(val, nums.size());

            nums.add(nums.size(), val);

            return true;
        }

        public boolean remove(int val) {
            if (!numToIdx.containsKey(val)) {
                return false;
            }

            int delIdx = numToIdx.get(val);
            int lastIdx = nums.size() - 1;
            int lastElem = nums.get(lastIdx);

            nums.set(delIdx, lastElem);
            numToIdx.put(lastElem, delIdx);

            nums.remove(lastIdx);
            numToIdx.remove(val);

            return true;
        }

        public int getRandom() {
            Random rand = new Random();

            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
