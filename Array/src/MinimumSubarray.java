import java.util.List;

/**
 * @author yanliu
 * @create 2021-10-29-12:54 AM
 */
public class MinimumSubarray {
    /**
     * using dp to solve the problem
     */
    static class Solution1 {
        public static int minSubarray(List<Integer> nums) {
            if (nums == null || nums.size() == 0) {
                return Integer.MAX_VALUE;
            }

            // use dp array
            // min[i] -> the minimum continuous subarray in i
            int[] min = new int[nums.size()];
            min[0] = nums.get(0);

            int minSum = nums.get(0);

            for (int i = 1; i < nums.size(); i++) {
                min[i] = Math.min(min[i - 1] + nums.get(i), nums.get(i));
                minSum = Math.min(minSum, min[i]);
            }

            return minSum;

        }
    }

    /**
     * using kadane's algorithm to solve the problem
     */
    static class Solution2 {
        public int minSubarraySum(List<Integer> nums) {
            if (nums == null || nums.size() == 0) {
                return Integer.MAX_VALUE;
            }

            int minEndingHere = 0;
            int minSoFar = Integer.MAX_VALUE;

            for (int i = 0; i < nums.size(); i++) {
                minEndingHere += nums.get(i);

                if (minEndingHere > nums.get(i)) {
                    minEndingHere = nums.get(i);
                }

                if (minSoFar > minEndingHere) {
                    minSoFar = minEndingHere;
                }
            }

            return minSoFar;
        }
    }
}
