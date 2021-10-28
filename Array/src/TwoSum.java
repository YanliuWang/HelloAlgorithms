import java.util.*;

/**
 * @author yanliu
 * @create 2020-11-17-9:35
 */
public class TwoSum {
    static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return new int[0];
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }

                map.put(nums[i], i);
            }

            return new int[0];

        }
    }

    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];

            if (nums == null || nums.length < 2) {
                return result;
            }

            Arrays.sort(nums);

            int left = 0, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result[0] = left;
                    result[1] = right;

                    return result;
                }

                if (sum > target) {
                    right--;
                }

                if (sum < target) {
                    left++;
                }
            }

            return result;
        }
    }

    /**
     * Lintcode 607: two sum with two operations
     * use hashmap
     */
    class Solution3 {
        private Map<Integer, Integer> numToFreq = new HashMap<>();

        /**
         * @param number: An integer
         * @return: nothing
         */
        public void add(int number) {
            // write your code here
            numToFreq.put(number, numToFreq.getOrDefault(number, 0) + 1);
        }

        /**
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            // write your code here
            for (Integer num1 : numToFreq.keySet()) {
                int complement = value - num1;

                int complementFreq = complement == num1 ? 2 : 1;

                if (numToFreq.getOrDefault(complement, 0) >= complementFreq) {
                    return true;
                }
            }

            return false;
        }
    }

}
