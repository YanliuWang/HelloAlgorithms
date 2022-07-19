/**
 * LeetCode59
 * @author yanliu
 * @create 2022-06-19-11:17 AM
 */
public class SpiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n <= 0) {
                return new int[0][0];
            }

            int[][] matrix = new int[n][n];

            int startRow = 0, endRow = n - 1;
            int startCol = 0, endCol = n - 1;
            int num = 1;

            while (startRow <= endRow && startCol <= endCol) {
                for (int col = startCol; col <= endCol; col++) {
                    matrix[startRow][col] = num;
                    num++;
                }

                for (int row = startRow + 1; row <= endRow; row++) {
                    matrix[row][endCol] = num;
                    num++;
                }

                for (int col = endCol - 1; col >= startCol; col--) {
                    if (startRow == endRow) {
                        break;
                    }

                    matrix[endRow][col] = num;
                    num++;
                }

                for (int row = endRow - 1; row >= startRow + 1; row--) {
                    if (startCol == endCol) {
                        break;
                    }

                    matrix[row][startCol] = num;
                    num++;
                }

                startRow++;
                endRow--;
                startCol++;
                endCol--;

            }

            return matrix;
        }
    }
}
