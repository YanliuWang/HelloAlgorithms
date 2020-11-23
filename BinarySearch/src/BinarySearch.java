/**
 * @author yanliu
 * @create 2020-11-23-16:38
 */
public class BinarySearch {
    /**
     *
     * @param nums
     * @param target
     * @return index of given target in nums array
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;

            } else if (target > nums[mid]) {
                left = mid + 1;

            } else if (target == nums[mid]){
                return mid;

            }
        }

        return -1;

    }

    public static int leftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;

            } else if (target > nums[mid]){
                left = mid + 1;

            } else if (target == nums[mid]) {
                // move to the left side to find the left bound
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;

        }

        return left;

    }

    public static int rightBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;

            } else if (target > nums[mid]){
                left = mid + 1;

            } else if (target == nums[mid]) {
                // move to the right side to find the right bound
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }
}
