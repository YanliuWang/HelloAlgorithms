/**
 * @author yanliu
 * @create 2022-01-06-2:03 PM
 */

import java.util.List;

/**
 * Problem: Given a square grid of integers and an integer value, maxSum,
 *          determine the maximum size of the square sub-grid where for all
 *          such sub-grids, the sum of all its elements' values is less than
 *          or equal to the value maxSum
 */
public class LargestSubGrid {
    static class Solution {
        public int largestSubgrid(List<List<Integer>> grid, int maxSum) {
            int n = grid.size();
            int[][] prefixSum = new int[n][n];

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        prefixSum[i][j] = grid.get(i).get(j);

                    } else if (i == 0) {
                        prefixSum[0][j] = prefixSum[0][j - 1] + grid.get(0).get(j);

                    } else if (j == 0) {
                        prefixSum[i][0] = prefixSum[i - 1][0] + grid.get(i - 1).get(0);

                    } else {
                        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                                - prefixSum[i - 1][j - 1] + grid.get(i).get(j);

                    }

                    max = Math.max(max, grid.get(i).get(j));
                }
            }

            if (max > maxSum) {
                return 0;
            }

            if (max >= prefixSum[n - 1][n - 1]) {
                return n;
            }

            // using binary search in the 2D array
            int l = 0, r = n;

            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                int res = 0;

                for(int i = mid - 1; i < n; i++){
                    for(int j = mid - 1; j < n; j++){
                        int total = prefixSum[i][j];

                        if(i >= mid) total -= prefixSum[i - mid][j];
                        if(j >= mid) total-= prefixSum[i][j - mid];
                        if(i >= mid && j >= mid) total += prefixSum[i - mid][j - mid];

                        res = Math.max(res, total);
                    }
                }

                if(maxSum >= res) l = mid;
                else r = mid - 1;
            }

            return r;
        }
    }
}
