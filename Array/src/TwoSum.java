import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        new Solution2().twoSum(new int[]{3, 2, 4}, 6);
    }
}
