/**
 * @author yanliu
 * @create 2021-12-04-4:00 PM
 */
public class SearchInRotatedSortedArray {
    /**
     * LeetCode33
     */
    class Solution1 {
        public int search(int[] nums, int target) {
            // TODO: Write - Your - Code
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                if (nums[mid] >= nums[left]) {
                    // the first half [left, mid - 1] is sorted
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;

                    } else {
                        left = mid + 1;

                    }

                } else {
                    // the second half [mid + 1, right]
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;

                    } else {
                        right = mid - 1;
                    }


                }
            }

            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            return -1;
        }
    }


    /**
     * LeetCode33
     */
    class Solution2 {
        int binarySearchRotated(int[] nums, int target) {
            // TODO: Write - Your - Code
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target == nums[mid]) {
                    return mid;
                }

                if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;

                    } else {
                        left = mid + 1;

                    }

                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;

                    } else {
                        right = mid - 1;

                    }

                }
            }

            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            return -1;
        }
    }

    /**
     * LeetCode81
     */
    class Solution3 {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                // we can not conclude which side is sorted
                // the first half could be out of order
                // [3 1 2 3 3 3 3]
                // move the left -> right
                // 1. since target != nums[mid] && target != nums[left]
                // 2. decrease the search scope
                if (nums[mid] == nums[left]) {
                    left++;

                } else if (nums[mid] > nums[left]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;

                    } else {
                        left = mid + 1;

                    }

                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;

                    } else {
                        right = mid - 1;

                    }
                }
            }

            return nums[left] == target || nums[right] == target;
        }
    }
}
