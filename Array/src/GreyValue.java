/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-10:22 AM
 */
public class GreyValue {
    static class Solution {
        public int findMaxGrey(int[][] arr) {
            if (arr == null || arr.length == 0
                    || arr[0] == null || arr[0].length == 0) {
                return 0;
            }

            int row = arr.length;
            int col = arr[0].length;

            int[] rowsGrey = new int[row];
            int[] colsGrey = new int[col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int grey = arr[i][j] == 0 ? -1 : 1;
                    rowsGrey[i] += grey;
                    colsGrey[j] += grey;
                }
            }

            int res = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res = Math.max(res, rowsGrey[i] + colsGrey[j]);
                }
            }

            return res;



        }
    }
}
