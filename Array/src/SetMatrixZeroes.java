import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode73
 * @author yanliu
 * @create 2021-12-09-12:16 PM
 */
public class SetMatrixZeroes {
    static class Solution1 {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rowIndex = new HashSet<>();
            Set<Integer> colIndex = new HashSet<>();

            int row = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        rowIndex.add(i);
                        colIndex.add(j);
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (rowIndex.contains(i) || colIndex.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    static class Solution2 {
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            boolean row0Flag = false;
            boolean col0Flag = false;

            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    col0Flag = true;
                }
            }

            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    row0Flag = true;
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (row0Flag) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }

            if (col0Flag) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
