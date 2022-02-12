import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode89
 * @author yanliu
 * @create 2021-12-22-7:59 PM
 */
public class GrayCode {
    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);

            for (int i = 0; i < n; i++) {
                int k = 1 << i;
                int size = res.size();

                for (int j = size - 1; j >= 0; j--) {
                    res.add(res.get(j) + k);
                }
            }

            return res;
        }
    }
}
