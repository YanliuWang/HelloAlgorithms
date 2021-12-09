/**
 * LeetCode 134
 * @author yanliu
 * @create 2021-11-20-11:02 PM
 */
public class GasStation {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalTank = 0;
            int n = gas.length;

            for (int i = 0; i < n; i++) {
                totalTank += gas[i] - cost[i];
            }

            if (totalTank < 0) {
                return -1;
            }

            int currTank = 0, start = 0;
            for (int i = 0; i < n; i++) {
                currTank += gas[i] - cost[i];

                if (currTank < 0) {
                    start = i + 1;
                    currTank = 0;
                }
            }

            return start;
        }
    }
}
