/**
 * LeetCode33
 * @author yanliu
 * @create 2021-12-04-4:00 PM
 */
public class SearchInRotatedSortedArray {
    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target == nums[mid]) {
                    return mid;

                } else if (nums[mid] >= nums[0]) {
                    if (target >= nums[0] && target <= nums[mid]) {
                        end = mid - 1;

                    } else {
                        start = mid + 1;
                    }

                } else {
                    if (target >= nums[mid] && target <= nums[nums.length - 1]) {
                        start = mid + 1;

                    } else {
                        end = mid - 1;
                    }

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
