import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode118
 * @author yanliu
 * @create 2021-12-08-10:46 AM
 */
public class PascalTriangle {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();

            if (numRows <= 0) {
                return res;
            }

            for (int i = 0; i < numRows; i++) {
                List<Integer> curr = new ArrayList<>();

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        curr.add(1);

                    } else {
                        curr.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));

                    }
                }

                res.add(curr);
            }

            return res;


        }
    }
}
