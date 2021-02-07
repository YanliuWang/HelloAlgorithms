import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LC996
 * @author yanliu
 * @create 2021-02-07-10:20
 */
public class NumSquarefulPerms {
    static class Solution {
        private int ans;

        public int numSquarefulPerms(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }

            Arrays.sort(A);
            boolean[] used = new boolean[A.length];
            List<Integer> curr = new LinkedList<>();

            backTrack(curr, A, used);

            return ans;
        }

        private void backTrack(List<Integer> curr, int[] A, boolean[] used) {
            if (curr.size() == A.length) {
                ans++;
                return;
            }

            for (int i = 0; i < A.length; i++) {
                if (used[i]) {
                    continue;
                }

                if (i > 0 && A[i] == A[i - 1] && !used[i - 1]) {
                    continue;
                }

                if (!curr.isEmpty() && !squareful(curr.get(curr.size() - 1), A[i])) {
                    continue;
                }

                curr.add(A[i]);
                used[i] = true;

                backTrack(curr, A, used);

                curr.remove(curr.size() - 1);
                used[i] = false;

            }
        }

        private boolean squareful(int x, int y) {
            int z = (int) Math.sqrt(x + y);

            return z * z == x + y;
        }
    }

}
