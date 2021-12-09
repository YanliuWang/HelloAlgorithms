/**
 * LeetCode 498
 * @author yanliu
 * @create 2021-11-16-10:39 AM
 */
public class DiagonalTraverse {
    static class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            // 1. the sum of index is same for elements in the same diagonal
            // 2. sum is odd, go down left; sum is even, go up right
            // 3. there is space for diagonal
            // 4. there is no space for a row, have space for a col
            // 5. there is no space for a col, have space for a row

            int row = mat.length;
            int col = mat[0].length;

            int[] res = new int[row * col];
            int currRow = 0, currCol = 0;

            for (int i = 0; i < row * col; i++) {
                res[i] = mat[currRow][currCol];
                int sum = currRow + currCol;


                if (sum % 2 == 0) {
                    // up right
                    if (currRow - 1 >= 0 && currCol + 1 < col) {
                        currRow = currRow - 1;
                        currCol = currCol + 1;

                    } else if (currCol + 1 < col) {
                        // no space for a row
                        // go right
                        currCol = currCol + 1;

                    } else {
                        // no space for a col
                        // go down
                        currRow = currRow + 1;

                    }

                } else {
                    // down left
                    if (currRow + 1 < row && currCol - 1 >= 0) {
                        currRow = currRow + 1;
                        currCol = currCol - 1;

                    } else if (currRow + 1 < row) {
                        currRow = currRow + 1;

                    } else {
                        currCol = currCol + 1;

                    }
                }
            }

            return res;

        }
    }
}
