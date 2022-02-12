/**
 * LeetCode1041
 * @author yanliu
 * @create 2022-01-13-3:35 PM
 */
public class RobotBoundedInCircle {
    static class Solution {
        private int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public boolean isRobotBounded(String instructions) {
            int dir = 0;
            int x = 0, y = 0;

            for (int i = 0; i < instructions.length(); i++) {
                if (instructions.charAt(i) == 'L') {
                    dir = (dir + 3) % 4;

                } else if (instructions.charAt(i) == 'R') {
                    dir = (dir + 1) % 4;

                } else {
                    x += direction[dir][0];
                    y += direction[dir][1];
                }
            }

            return (x == 0 && y == 0) || (dir != 0);
        }
    }
}
