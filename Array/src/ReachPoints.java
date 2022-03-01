/**
 * LeetCode780
 * @author yanliu
 * @create 2022-02-27-11:45 AM
 */
public class ReachPoints {
    static class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (tx > sx && ty > sy) {
                if (tx > ty) {
                    tx %= ty;

                } else {
                    ty %= tx;

                }
            }

            // check whether the target points changed to
            // (x, y + kx) || (x + ky, y)
            return tx == sx && ty >= sy && (ty - sy) % sx == 0
                    || sy == ty && sx <= tx && (tx - sx) % sy == 0;
        }
    }
}
