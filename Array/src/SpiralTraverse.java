import java.util.ArrayList;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/spiral-traverse
 * @author yanliu
 * @create 2022-06-18-7:42 PM
 */
public class SpiralTraverse {
    class Solution1 {
        public List<Integer> spiralTraverse(int[][] array) {
            // Write your code here.
            if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
                return new ArrayList<>();
            }

            List<Integer> res = new ArrayList<>();

            int startRow = 0, endRow = array.length - 1;
            int startCol = 0, endCol = array[0].length - 1;

            while (startRow <= endRow && startCol <= endCol) {
                for (int col = startCol; col <= endCol; col++) {
                    res.add(array[startRow][col]);
                }

                for (int row = startRow + 1; row <= endRow; row++) {
                    res.add(array[row][endCol]);
                }

                for (int col = endCol - 1; col >= startCol; col--) {
                    if (startRow == endRow) {
                        break;
                    }

                    res.add(array[endRow][col]);
                }

                for (int row = endRow - 1; row > startRow; row--) {
                    if (startCol == endCol) {
                        break;
                    }

                    res.add(array[row][startCol]);
                }

                startRow++;
                endRow--;
                startCol++;
                endCol--;
            }

            return res;
        }
    }

    class Solution2 {
        public List<Integer> spiralTraverse(int[][] array) {
            // Write your code here.
            if (array == null || array.length == 0
                    || array[0] == null || array[0].length == 0) {
                return new ArrayList<>();
            }

            List<Integer> res = new ArrayList<>();

            spiralAll(array, 0, array.length - 1, 0, array[0].length - 1, res);

            return res;
        }

        private void spiralAll(int[][] array, int startRow, int endRow,
                                      int startCol, int endCol, List<Integer> res) {
            if (startRow > endRow || startCol > endCol) {
                return;
            }

            for (int col = startCol; col <= endCol; col++) {
                res.add(array[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                res.add(array[row][endCol]);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) {
                    break;
                }

                res.add(array[endRow][col]);
            }

            for (int row = endRow - 1; row >= startRow + 1; row--) {
                if (startCol == endCol) {
                    break;
                }

                res.add(array[row][startCol]);
            }

            spiralAll(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, res);
        }
    }


}
