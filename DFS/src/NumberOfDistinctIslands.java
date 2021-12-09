import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 694
 * @author yanliu
 * @create 2021-12-03-3:39 PM
 */
public class NumberOfDistinctIslands {
    static class Solution {
        public int numDistinctIslands(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;

            Set<String> islands = new HashSet<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder island = new StringBuilder();
                        dfs(grid, i, j, i, j, island);
                        islands.add(island.toString());
                    }
                }
            }

            return islands.size();
        }

        private void dfs(int[][] grid, int x, int y, int originX, int originY, StringBuilder island) {
            int row = grid.length;
            int col = grid[0].length;

            if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) {
                return;
            }

            grid[x][y] = 0;

            island.append(x - originX);
            island.append(y - originY);

            dfs(grid, x + 1, y, originX, originY, island);
            dfs(grid, x, y + 1, originX, originY, island);
            dfs(grid, x - 1, y, originX, originY, island);
            dfs(grid, x, y - 1, originX, originY, island);


        }
    }
}
