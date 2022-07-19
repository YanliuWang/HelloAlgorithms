import java.util.LinkedList;

/**
 * @author yanliu
 * @create 2022-07-12-9:59 AM
 */
public class GoodArray {
    static class Solution {
        public int[] getQueryResults(long n, int[][] queries) {
            if (n <= 0 || queries == null || queries.length == 0
                    || queries[0] == null || queries[0].length == 0) {
                return new int[0];
            }

            LinkedList<Integer> goodArray = new LinkedList<>();

            for (int i = 0; i < 63; i++) {
                if (((n >> i) & 1) == 1) {
                    goodArray.add((int) Math.pow(2, i));
                }
            }

            System.out.println(goodArray);
            int len = goodArray.size();
            int[] prefix = new int[len + 1];
            prefix[0] = 1;

            for (int i = 1; i < prefix.length; i++) {
                prefix[i] = prefix[i - 1] * goodArray.get(i - 1);
            }

            int[] res = new int[queries.length];

            for (int i = 0; i < res.length; i++) {
                res[i] = (prefix[queries[i][1]] / prefix[queries[i][0] - 1]) % queries[i][2] ;
            }

            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long n = 26;
        int[][] queries = new int[][]{{1, 2, 1009}, {3, 3, 5}};
        int[] res = solution.getQueryResults(n, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
