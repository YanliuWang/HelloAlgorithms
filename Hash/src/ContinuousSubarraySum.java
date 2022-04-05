import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode523
 * @author yanliu
 * @create 2022-04-04-12:44 PM
 */
public class ContinuousSubarraySum {
    static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            Map<Integer, Integer> prefixsumToIndex = new HashMap<>();
            prefixsumToIndex.put(0, -1);

            int currSum = 0;

            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];

                int remainder = currSum % k;

                if (prefixsumToIndex.containsKey(remainder)) {
                    int prev = prefixsumToIndex.get(remainder);

                    if (i - prev > 1) {
                        return true;
                    }

                } else {
                    prefixsumToIndex.put(remainder, i);

                }
            }

            return false;

        }
    }
}
