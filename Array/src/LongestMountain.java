/**
 * @author yanliu
 * @create 2020-12-08-17:35
 */
public class LongestMountain {
    public int LongestMountain(int[] A) {
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
