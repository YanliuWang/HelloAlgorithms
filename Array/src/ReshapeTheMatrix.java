/**
 * LeetCode566
 * @author yanliu
 * @create 2021-12-08-11:02 AM
 */
public class ReshapeTheMatrix {
    static class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int row = mat.length;
            int col = mat[0].length;

            if (row * col != r * c) {
                return mat;
            }
            
            // 1.convert the original array to one dimension
            //      1.1 (i, j) = i * col + j
            //      1.2 i = (i * col + j) / col
            //      1.3 j = (i * col + j) % col
            // 2.convert the one dimension array to multiple dimension

            int[][] ans = new int[r][c];
            for (int i = 0; i < row * col; i++) {
                ans[i / c][i % c] = mat[i / col][i % col];
            }

            return ans;
        }
    }
}
