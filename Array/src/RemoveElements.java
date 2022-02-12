/**
 * LeetCode27
 * @author yanliu
 * @create 2022-02-09-11:06 PM
 */
public class RemoveElements {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int slow = 0, fast = 0;

            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }

                fast++;
            }

            return slow;
        }
    }
}
