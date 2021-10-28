/**
 * @author yanliu
 * @create 2021-10-16-5:47 PM
 */
public class MaximumNumberInMountainSequence {
    public class Solution {
        /**
         * @param nums: a mountain sequence which increase firstly and then decrease
         * @return: then mountain top
         */
        public int mountainSequence(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (nums[mid + 1] > nums[mid]) {
                    start = mid;

                } else {
                    end = mid;
                }
            }

            return Math.max(nums[start], nums[end]);

        }
    }
}
