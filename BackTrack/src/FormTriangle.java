

/**
 * @author yanliu
 * @create 2021-03-19-15:58
 */
public class FormTriangle {
        static class Solution {
            private int TRIANGLE_SIDES = 3;

            boolean canFormTriangle(int[] sticks) {
                if (sticks == null || sticks.length < TRIANGLE_SIDES) {
                    return false;
                }

                int sum = 0;

                for (int i = 0; i < sticks.length; i++) {
                    sum += sticks[i];
                }

                if (sum % TRIANGLE_SIDES != 0) {
                    return false;
                }

                int targetSide = sum / TRIANGLE_SIDES;
                int[] sides = new int[TRIANGLE_SIDES];

                return dfs(sticks, targetSide, sides, 0);

            }

            boolean dfs(int[] sticks, int targetSide, int[] sides, int level) {
                if (level == sticks.length) {
                    if (isEquilateral(sides, targetSide)) {
                        return true;
                    }

                    return false;
                }

                for (int i = 0; i < sides.length; i++) {
                    if (sides[i] + sticks[level] > targetSide) {
                        continue;
                    }

                    sides[i] += sticks[level];

                    if (dfs(sticks, targetSide, sides, level + 1)) {
                        return true;
                    }

                    sides[i] -= sticks[level];
                }

                return false;
            }

            private boolean isEquilateral(int[] sides, int targetSide) {
                for (int i = 0; i < sides.length - 1; i++) {
                    if (sides[i] != targetSide) {
                        return false;
                    }
                }

                return true;
            }

            public static void main(String[] args) {
                boolean b = new Solution().canFormTriangle(new int[]{1, 2, 3, 3});

                System.out.println(b);
            }
        }

}
