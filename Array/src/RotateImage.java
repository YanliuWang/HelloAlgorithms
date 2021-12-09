/**
 * LeetCode48
 * @author yanliu
 * @create 2021-12-05-12:11 PM
 */
public class RotateImage {
    static class Solution {
        /**
         * clockwise rotate
         * first reverse up to down, then swap the symmetry
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
         *
         * anticlockwise rotate
         * first reverse left to right, then swap the symmetry
         * 1 2 3     3 2 1     3 6 9
         * 4 5 6  => 6 5 4  => 2 5 8
         * 7 8 9     9 8 7     1 4 7
         *
         */
        public void rotate(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;

            // swap up to down
            for (int start = 0, end = row - 1; start < end; start++, end--) {
                for (int i = 0; i < col; i++) {
                    int tmp = matrix[start][i];
                    matrix[start][i] = matrix[end][i];
                    matrix[end][i] = tmp;
                }
            }

            // reverse between symmetry
            for (int i = 0; i < row; i++) {
                for (int j = i + 1; j < col; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

    }
}
