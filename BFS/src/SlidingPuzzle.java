import java.util.*;

/**
 * LeetCode773
 * @author yanliu
 * @create 2022-04-22-10:26 PM
 */
public class SlidingPuzzle {
    static class Solution {
        private int[] dx = {-1, 0, 0, 1};
        private int[] dy = {0, 1, -1, 0};

        public int slidingPuzzle(int[][] board) {
            if (board == null || board.length == 0
                    || board[0] == null || board[0].length == 0) {
                return 0;
            }

            String goal = "123450";

            int row = board.length;
            int col = board[0].length;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sb.append(board[i][j]);
                }
            }

            String start = sb.toString();
            if (goal.equals(start)) {
                return 0;
            }


            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.offer(start);
            visited.add(start);

            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String curr = queue.poll();

                    if (curr.equals(goal)) {
                        return step;
                    }

                    List<String> neighbours = getNeighbours(curr, row, col);

                    for (String neighbour : neighbours) {
                        if (visited.contains(neighbour)) {
                            continue;
                        }

                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }

                step++;
            }

            return -1;
        }

        private List<String> getNeighbours(String curr, int row, int col) {
            List<String> res = new ArrayList<>();
            char[] arr = curr.toCharArray();

            int zeroPos = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '0') {
                    zeroPos = i;
                    break;
                }
            }

            int zeroRow = zeroPos / col;
            int zeroCol = zeroPos % col;

            for (int i = 0; i < 4; i++) {
                arr = curr.toCharArray();
                int nextX = zeroRow + dx[i];
                int nextY = zeroCol + dy[i];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                int nextPos = nextX * col + nextY;

                swap(arr, zeroPos, nextPos);

                res.add(new String(arr));

            }

            return res;
        }

        private void swap(char[] arr, int i, int j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
