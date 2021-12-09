/**
 * LeetCode 35
 * @author yanliu
 * @create 2021-12-03-8:01 PM
 */
public class SearchInsertPosition {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target == nums[mid]) {
                    return mid;

                } else if (target > nums[mid]) {
                    start = mid;

                } else {
                    end = mid;
                }
            }

            if (target == nums[start]) {
                return start;
            }

            if (target == nums[end]) {
                return end;
            }

            if (target > nums[start] && target < nums[end]) {
                return start + 1;
            }

            if (target < nums[start]) {
                return start - 1 >= 0 ? start - 1 : 0;
            }


            return end + 1;
        }
    }
}
