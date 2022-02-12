import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode325
 * @author yanliu
 * @create 2022-01-20-12:19 PM
 */
public class MaximumSizeSubarraySumEqualsK {
    static class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> prefixsumToIdx = new HashMap<>();
            int prefixSum = 0;
            int maxLen = 0;

            // cover the case that sum from 0 to index is k
            prefixsumToIdx.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];

                if (prefixsumToIdx.containsKey(prefixSum - k)) {
                    maxLen = Math.max(maxLen, i - prefixsumToIdx.get(prefixSum - k));
                }

                if (!prefixsumToIdx.containsKey(prefixSum)) {
                    prefixsumToIdx.put(prefixSum, i);
                }

            }

            return maxLen;
        }
    }
}
