/**
 * LeetCode136
 * @author yanliu
 * @create 2021-12-16-10:55 AM
 */
public class SingleNumber {
    static class Solution {
        public int singleNumber(int[] nums) {
            int res = nums[0];

            for (int i = 1; i < nums.length; i++) {
                res ^= nums[i];
            }

            return res;
        }
    }
}
