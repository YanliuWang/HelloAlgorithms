import java.util.ArrayList;
import java.util.List;

/**
 * @author yanliu
 * @create 2021-03-14-15:09
 */
public class GrayCode {
    static class Solution1 {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();

            getGrayCode(n, result);

            return result;
        }

        private void getGrayCode(int n, List<Integer> result) {
            if (n == 0) {
                result.add(0);
                return;
            }

            getGrayCode(n - 1, result);

            int size = result.size();
            int k = 1 << (n - 1);

            for (int i = size - 1; i >= 0; i--) {
                result.add(result.get(i) + k);
            }
        }
    }

    /**
     * iterative way
     */
    static class Solution2 {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            result.add(0);

            for (int i = 0; i < n; i++) {
                int k = 1 << i;
                int size = result.size();

                for (int j = size - 1; j >= 0; j--) {
                    result.add(result.get(j) + k);
                }
            }

            return result;
        }
    }
}
