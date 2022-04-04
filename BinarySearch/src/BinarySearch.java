import java.util.ArrayList;
import java.util.List;

/**
 * @author yanliu
 * @create 2020-11-23-16:38
 */
public class BinarySearch {

    static class Solution1 {
        /**
         * LeetCode704
         * find the index of given target in nums
         * @param nums
         * @param target
         * @return index of given target in nums array
         */
        public int binarySearch(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;

            // start + 1 < end to avoid endless loop
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) {
                    return mid;
                }

                if (target < nums[mid]) {
                    end = mid - 1;

                } else {
                    start = mid + 1;

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

    static class Solution2 {
        /**
         * Leetcode74
         * apply binary search in 2d space
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0
                    || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }

            int row = matrix.length;
            int col = matrix[0].length;

            int left = 0, right = row * col - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                int currX = mid / col;
                int currY = mid % col;

                if (target == matrix[currX][currY]) {
                    return true;

                }

                if (target > matrix[currX][currY]) {
                    left = mid + 1;

                } else {
                    right = mid - 1;

                }
            }

            if (matrix[left / col][left % col] == target
                    || matrix[right / col][right % col] == target) {
                return true;
            }

            return false;
        }
    }

    static class Solution3 {
        /**
         * LintCode459
         * find an element in the array that is closest to the target
         * @param nums
         * @param target
         * @return
         */
        public static int binarySearch(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (target == nums[mid]) {
                    return mid;
                }

                if (target < nums[mid]) {
                    right = mid;

                } else {
                    left = mid;

                }
            }

            if (Math.abs(nums[left] - target) < Math.abs(nums[right] - target)) {
                return left;
            }

            return right;
        }
    }

    static class Solution4 {
        /**
         * LintCode14
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

                if (target == nums[mid]) {
                    end = mid;

                } else if (target < nums[mid]) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
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

    static class Solution5 {
        /**
         * LintCode458
         * @param nums: An integer array sorted in ascending order
         * @param target: An integer
         * @return: The last position of target. Position starts from 0.
         */
        public int lastPosition(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target == nums[mid]) {
                    start = mid;

                } else if (target > nums[mid]) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }
            }

            if (nums[end] == target) {
                return end;
            }

            if (nums[start] == target) {
                return start;
            }

            return -1;
        }
    }

    static class Solution6 {
        public class Solution {
            /**
             * LeetCode658
             * @param arr: an integer array
             * @param target: An integer
             * @param k: An integer
             * @return: an integer array
             */
            public List<Integer> findClosestElements(int[] arr, int k, int target) {
                List<Integer> res = new ArrayList<>();

                if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
                    return res;
                }

                int left = 0, right = arr.length - 1;

                while (left + 1 < right) {
                    int mid = left + (right - left) / 2;

                    if (target < arr[mid]) {
                        right = mid;

                    } else if (target > arr[mid]){
                        left = mid;

                    } else {
                        right = mid;

                    }
                }

                while (right - left - 1 < k) {
                    if (left == -1) {
                        right++;
                        continue;
                    }

                    if (right == arr.length || (Math.abs(arr[left] - target)
                            <= Math.abs(arr[right] - target))) {
                        left--;

                    } else {
                        right++;

                    }
                }

                for (int i = left + 1; i < right; i++) {
                    res.add(arr[i]);
                }

                return res;
            }
        }
    }
}
