import java.util.ArrayList;
import java.util.List;

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

                } else {
                    return mid;
                }
            }

            return -1;
        }
    }

    static class Solution2 {
        /**
         * apply binary search in 2d space
         * @param matrix
         * @param target
         * @return
         */
        public static boolean binarySearch2D(int[][] matrix, int target) {
            int row = matrix.length;
            int col = matrix[0].length;

            int left = 0, right = row * col - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int r = mid / col;
                int c = mid % col;

                if (target == matrix[r][c]) {
                    return true;

                } else if (target < matrix[r][c]) {
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }

            return false;
        }
    }

    static class Solution3 {
        /**
         * find an element in the array that is closest to the target
         * @param nums
         * @param target
         * @return
         */
        public static int binarySearch(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {
                return left;

            } else {
                return right;

            }
        }
    }

    static class Solution4 {
        /**
         * find the index of the first occurrence of an element
         * @param nums
         * @param target
         * @return
         */
        public static int leftBound(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            // if left neighbors right -> terminate
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target == nums[mid]) {
                    right = mid;

                } else if (target < nums[mid]) {
                    right = mid - 1;

                } else {
                    left = mid + 1;

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

    static class Solution5 {
        /**
         * find the index of the last occurrence of an element
         * @param nums
         * @param target
         * @return
         */
        public int rightBound(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            // if left neighbors right -> terminate
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target < nums[mid]) {
                    right = mid - 1;

                } else if (target > nums[mid]) {
                    left = mid + 1;

                } else {
                    left = mid;
                }
            }

            if (nums[right] == target) {
                return right;
            }

            if (nums[left] == target) {
                return left;
            }

            return -1;

        }
    }

    static class Solution6 {
        /**
         * find k elements that are closest to target
         * @param nums
         * @param target
         * @return
         */
        public List<Integer> findKElements(int[] nums, int target, int k) {
            List<Integer> kElements = new ArrayList<>(k);

            if (nums == null || nums.length == 0 || k > nums.length) {
                return kElements;
            }

            int left = 0, right = nums.length - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target <= nums[mid]) {
                    right = mid;
                } else if (target > nums[mid]) {
                    left = mid;
                }
            }

            while (k-- >= 0 && left >= 0 && right < nums.length) {
                if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {
                    kElements.add(nums[left]);
                } else {
                    kElements.add(nums[right]);
                }

                left--;
                right++;
            }

            while (k-- >= 0 && left >= 0) {
                kElements.add(nums[left]);
                left--;
            }

            while (k-- >= 0 && right < nums.length) {
                kElements.add(nums[right]);
                right++;
            }

            return kElements;
        }
    }
}
