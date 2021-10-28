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
         * @param nums: An integer array sorted in ascending order
         * @param target: An integer
         * @return: An integer
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
             * @param A: an integer array
             * @param target: An integer
             * @param k: An integer
             * @return: an integer array
             */
            public int[] kClosestNumbers(int[] A, int target, int k) {
                // write your code here
                if (A == null || A.length == 0 || k <= 0 || k > A.length) {
                    return new int[0];
                }

                List<Integer> res = new ArrayList<>();

                int start = 0, end = A.length - 1;

                while (start + 1 < end) {
                    int mid = start + (end - start) / 2;

                    if (target <= A[mid]) {
                        end = mid;

                    } else {
                        start = mid;

                    }
                }

                while (k > 0 && start >= 0 && end < A.length) {
                    if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
                        res.add(A[start]);
                        start--;

                    } else {
                        res.add(A[end]);
                        end++;

                    }

                    k--;

                }

                while (k > 0 && start >= 0) {
                    res.add(A[start]);
                    start--;
                    k--;
                }

                while (k > 0 && end < A.length) {
                    res.add(A[end]);
                    end++;
                    k--;
                }

                return res.stream().mapToInt(i->i).toArray();
            }
        }
    }
}
