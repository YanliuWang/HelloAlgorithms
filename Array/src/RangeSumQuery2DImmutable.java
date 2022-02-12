/**
 * LeetCode304
 * @author yanliu
 * @create 2022-02-08-11:43 AM
 */
public class RangeSumQuery2DImmutable {
    class NumMatrix {
        private int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            prefixSum = getPrefixSum(matrix);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2 + 1][col2 + 1]
                    - prefixSum[row1][col2 + 1]
                    - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
        }

        private int[][] getPrefixSum(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            int[][] prefixSum = new int[row + 1][col + 1];

            for (int r = 1; r <= row; r++) {
                for (int c = 1; c <= col; c++) {
                    prefixSum[r][c] = prefixSum[r - 1][c]
                            + prefixSum[r][c - 1] + matrix[r - 1][c - 1]
                            - prefixSum[r - 1][c - 1];
                }
            }

            return prefixSum;
        }
    }
}
