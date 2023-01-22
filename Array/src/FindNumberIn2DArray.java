/**
 * 剑指 Offer 04. 二维数组中的查找
 * @author yanliu
 * @create 2023-01-22-8:33 PM
 */
public class FindNumberIn2DArray {
    static class Solution1 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }

            int n = matrix.length;

            int startRow = 0, endRow = n - 1;

            while (startRow + 1 < endRow) {
                int mid = startRow + (endRow - startRow) / 2;

                if (target < matrix[mid][0]) {
                    endRow = mid - 1;

                } else {
                    startRow = mid;

                }
            }

            int targetRow = 0;

            if (matrix[endRow][0] <= target) {
                targetRow = endRow;
            } else if (matrix[startRow][0] <= target) {
                targetRow = startRow;
            } else {
                return false;
            }

            for (int row = targetRow; row >= 0; row--) {
                if (findTarget(matrix[row], target)) {
                    return true;
                }
            }

            return false;
        }

        private boolean findTarget(int[] nums, int target) {
            int start = 0, end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (target == nums[mid]) {
                    return true;
                }

                if (target > nums[mid]) {
                    start = mid + 1;

                } else {
                    end = mid - 1;

                }
            }

            return nums[start] == target || nums[end] == target;
        }
    }

    static class Solution2 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }

            int row = 0, col = matrix[0].length - 1;

            while (row < matrix.length && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                }

                if (matrix[row][col] > target) {
                    col--;

                } else {
                    row++;

                }
            }

            return false;
        }
    }
}
