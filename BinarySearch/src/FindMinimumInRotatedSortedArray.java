/**
 * LeetCode153
 * @author yanliu
 * @create 2021-10-16-6:20 PM
 */
public class FindMinimumInRotatedSortedArray {
    static class Solution1 {
        /**
         * @param nums: a rotated sorted array
         * @return: the minimum number in the array
         */
        public int findMin(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] > nums[0]) {
                    start = mid;

                } else if (nums[mid] < nums[0]) {
                    end = mid;

                } else {
                    break;

                }
            }

            return Math.min(nums[0], Math.min(nums[start], nums[end]));
        }
    }

    static class Solution2 {
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int n = nums.length;

            if (nums[0] < nums[n - 1]) {
                return nums[0];
            }

            int start = 0, end = n - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    return nums[mid];
                }

                if (nums[mid] > nums[0]) {
                    start = mid + 1;

                } else if (nums[mid] < nums[0]) {
                    end = mid - 1;
                }
            }

            return nums[start] < nums[end] ? nums[start] : nums[end];
        }
    }
}
