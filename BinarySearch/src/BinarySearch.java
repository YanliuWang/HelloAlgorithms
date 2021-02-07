/**
 * @author yanliu
 * @create 2020-11-23-16:38
 */
public class BinarySearch {

    static class Solution1 {
        /**
         * find the index of given target in nums
         * @param nums
         * @param target
         * @return index of given target in nums array
         */
        public int binarySearch(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (target < nums[mid]) {
                    left = mid + 1;

                } else if (target > nums[mid]) {
                    right = mid - 1;

                } else {
                    return nums[mid];
                }
            }

            return -1;
        }
    }

    static class Solution2 {
        /**
         * find the index of left bound of given target in nums
         * @param nums
         * @param target
         * @return
         */
        public int leftBound(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left >= nums.length || nums[left] != target) {
                return -1;
            }

            return left;
        }
    }

    static class Solution3 {
        /**
         * find the index of right bound of given target in nums
         * @param nums
         * @param target
         * @return
         */
        public int rightBound(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    left = mid + 1;
                }
            }

            if (right < 0 || nums[right] != target) {
                return -1;
            }

            return right;

        }
    }
}
