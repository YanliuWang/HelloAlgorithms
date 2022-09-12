import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode1029
 * @author yanliu
 * @create 2022-09-11-8:08 PM
 */
public class TwoCityScheduling {
    static class Solution1 {
        public int twoCitySchedCost(int[][] costs) {
            if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
                return 0;
            }

            Arrays.sort(costs, new Comparator<>() {
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] - o1[1]) - (o2[0] - o2[1]);
                }
            });

            int n = costs.length;
            int cost = 0;

            for (int i = 0; i < n / 2; i++) {
                cost += costs[i][0];
            }

            for (int i = n / 2; i < n; i++) {
                cost += costs[i][1];
            }

            return cost;
        }
    }
}
