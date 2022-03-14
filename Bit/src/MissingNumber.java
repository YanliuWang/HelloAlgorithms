/**
 * LeetCode268
 * @author yanliu
 * @create 2022-03-10-10:54 AM
 */
public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int missing = nums.length;

            for (int i = 0; i < nums.length; i++) {
                missing ^= i ^ nums[i];
            }

            return missing;
        }
    }
}
