/**
 * @author yanliu
 * @create 2021-10-16-6:05 PM
 */
public class FirstPositionOfTarget {
    class Solution {
        /**
         * @param nums: The integer array.
         * @param target: Target to find.
         * @return: The first position of target. Position starts from 0.
         */
        public int binarySearch(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }

            return -1;
        }
    }
}
