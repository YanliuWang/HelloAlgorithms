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

                if (nums[mid] >= nums[0]) {
                    if (target >= nums[0] && target < nums[mid]) {
                        right = mid - 1;

                    } else {
                        left = mid + 1;

                    }

                } else {
                    if (target > nums[mid] && target < nums[0]) {
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
                // move the left -> right since target != nums[mid] && target != nums[left]
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
