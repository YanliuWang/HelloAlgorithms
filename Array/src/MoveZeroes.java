/**
 * LeetCode 283
 * @author yanliu
 * @create 2020-10-15-21:28
 */

public class MoveZeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            int nonZeroIdx = 0;
            int ptr = 0;

            while (ptr < nums.length) {
                int value = nums[ptr];

                if (value != 0) {
                    nums[nonZeroIdx++] = value;
                }

                ptr++;
            }

            while (nonZeroIdx < nums.length) {
                nums[nonZeroIdx++] = 0;
            }

        }
    }
}
