import java.util.LinkedList;
import java.util.List;

/**
 * LC77
 * @author yanliu
 * @create 2021-01-26-21:29
 */
public class Combinations {
    static class Solution1 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n < k) {
                return res;
            }

            List<Integer> tmp = new LinkedList<>();

            backTrack(tmp, n, k, 1);

            return res;
        }

        private void backTrack(List<Integer> tmp, int n, int remain, int start) {
            if (remain == 0) {
                res.add(new LinkedList<>(tmp));
                return;
            }

            for (int i = start; i <= n-remain+1; i++) {
                tmp.add(i);

                backTrack(tmp, n, remain-1, i+1);

                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
