/**
 * LeetCode34
 * @author yanliu
 * @create 2021-12-05-10:26 AM
 */
public class FindFirstLastPositionOfElementInSortedArray {
    static class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int n = nums.length;
            int first = -1, last = -1;

            int start = 0, end = n - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target <= nums[mid]) {
                    end = mid;

                } else {
                    start = mid + 1;
                }
            }

            if (nums[start] == target) {
                first = start;
            } else if (nums[end] == target) {
                first = end;
            }

            start = 0;
            end = n - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target >= nums[mid]) {
                    start = mid;

                } else {
                    end = mid - 1;
                }
            }

            if (nums[end] == target) {
                last = end;

            } else if (nums[start] == target) {
                last = start;
            }

            return new int[]{first, last};


        }
    }
}
