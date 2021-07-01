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
     */
    class Solution3 {
        // use list to store the nums
        private List<Integer> nums = new ArrayList<>();

        /**
         * the list is increasing order
         * @param number: An integer
         * @return: nothing
         */
        public void add(int number) {
            // write your code here
            // put the number to the list tail
            nums.add(number);

            // get the number index
            int index = nums.size() - 1;

            while (index > 0 && nums.get(index) < nums.get(index - 1)) {
                swap(nums, index);
                index--;
            }
        }

        private void swap(List<Integer> nums, int index) {
            int temp = nums.get(index);
            nums.set(index, nums.get(index - 1));
            nums.set(index - 1, temp);

        }

        /**
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            // write your code here
            int left = 0, right = nums.size() - 1;

            while (left < right) {
                int sum = nums.get(left) + nums.get(right);

                if (sum > value) {
                    right--;

                } else if (sum < value) {
                    left++;

                } else {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Lintcode 607: two sum with two operations
     * use hashmap
     */
    class Solution4 {
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
