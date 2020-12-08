/**
 * @author yanliu
 * @create 2020-12-08-17:35
 */
public class LongestMountain {
    /**
     * two pass solution
     */
    static class Solution1 {
        public int longestMountain(int[] A) {
            if (A == null || A.length == 0) {
                throw new IllegalArgumentException();
            }

            int res = 0, N = A.length;
            int[] up = new int[N], down = new int[N];

            for (int i = N - 2; i > -1; i--) {
                if (A[i] > A[i + 1]) {
                    down[i] = down[i + 1] + 1;
                }
            }

            for (int i = 1; i < N; i++) {
                if (A[i] > A[i - 1]) {
                    up[i] = up[i - 1] + 1;
                }

                if (up[i] > 0 && down[i] > 0) {
                    res = Math.max(res, up[i] + down[i] + 1);
                }
            }

            return res;
        }
    }

    /**
     * one pass solution
     */
    static class Solution2 {
        public int longestMountain(int[] A) {
            if (A == null || A.length == 0) {
                throw new IllegalArgumentException();
            }

            int res = 0, up = 0, down = 0;

            for (int i = 2; i < A.length; i++) {
                if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) {
                    up = down = 0;
                }

                if (A[i] > A[i - 1]) {
                    up++;

                } else {
                    down++;

                }

                if (up > 0 && down > 0) {
                    res = Math.max(res, up + down + 1);
                }

            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {2,1,4,7,3,2,5};
        assert(new Solution1().longestMountain(A) == 5);
        assert(new Solution2().longestMountain(A) == 5);
    }

}
