/**
 * LeetCode41
 * @author yanliu
 * @create 2022-02-17-11:55 PM
 */
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // numbers that are negative and greater than n
            // are all meaningless
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n + 1;
                }
            }

            // make the index->appearing numbers to negative
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);

                if (num > n) {
                    continue;
                }

                // zero-based index
                num--;

                if (nums[num] > 0) {
                    nums[num] = -1 * nums[num];
                }
            }

            // find the first non-negative numbers
            for (int i = 0; i < n; i++) {
                if (nums[i] >= 0) {
                    return i + 1;
                }
            }

            return n + 1;
        }
    }
}
