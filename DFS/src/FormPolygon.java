import java.util.Arrays;

/**
 * @author yanliu
 * @create 2021-03-20-9:10
 */
public class FormPolygon {
    /**
     * You have several sticks whose lengths may not be identical,
     * what you need to do is to decide if those sticks can make one polygon with equal sides.
     * You have to use up all the sticks and cannot break any of them.
     * You output will be a boolean variable: true or false
     *
     * Note: The problem of recursion limit would arise if python is used.
     * It is allowed to set the recursion limit using the sys module.
     */

    /**
     * judge whether the sticks can make one polygon with equal sides
     * @param sticks
     * @param side the length of each side
     * @return true or false
     */
    boolean formPolygon(int[] sticks, int side) {
        if (sticks == null || sticks.length < side) {
            return false;
        }

        // get sum of the sticks
        int sum = 0;
        for (int i = 0; i < sticks.length; i++) {
            sum += sticks[i];
        }

        // whether using the sum to construct a equal polygon
        if (sum % side != 0) {
            return false;
        }

        Arrays.sort(sticks);

        // the sides of the polygon
        int[] sides = new int[side];

        // get the target side of each polygon
        int targetSide = sum / side;

        return dfs(sticks, sides, targetSide, 0);
    }

    private static boolean dfs(int[] sticks, int[] sides, int targetSide, int start) {
        if (start == sticks.length) {
            for (int i = 0; i < sides.length - 1; i++) {
                if (sides[i] != targetSide) {
                    return false;
                }
            }

            return true;
        }

        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + sticks[start] > targetSide) {
                break;
            }

            sides[i] = sides[i] + sticks[start];

            if (dfs(sticks, sides, targetSide, start + 1)) {
                return true;
            }

            sides[i] = sides[i] - sticks[start];
        }

        return false;
    }

    public static void main(String[] args) {
        boolean b = new FormPolygon().formPolygon(new int[]{1, 2, 3, 3}, 3);

        System.out.println(b);
    }
}
