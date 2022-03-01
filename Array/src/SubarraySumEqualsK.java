import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode560
 * @author yanliu
 * @create 2021-12-27-6:12 PM
 */
public class SubarraySumEqualsK {
    static class Solution1 {
        public int subarraySum(int[] nums, int k) {
            int[] prefixSum = getPrefixSum(nums);
            int n = prefixSum.length;
            int res = 0;

            // find the two elements differing in k
            for (int start = 0; start < n; start++) {
                for (int end = start + 1; end < n; end++) {
                    if (prefixSum[end] - prefixSum[start] == k) {
                        res++;
                    }
                }
            }

            return res;
        }

        private int[] getPrefixSum(int[] nums) {
            int n = nums.length;
            int[] prefixSum = new int[n + 1];


            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            return prefixSum;
        }

    }

    static class Solution2 {
        public int subarraySum(int[] nums, int k) {
            int count = 0, currSum = 0;
            HashMap<Integer, Integer> h = new HashMap();

            for (int num : nums) {
                // current prefix sum
                currSum += num;

                // situation 1:
                // continuous subarray starts
                // from the beginning of the array
                if (currSum == k)
                    count++;

                // situation 2:
                // number of times the curr_sum − k has occurred already,
                // determines the number of times a subarray with sum k
                // has occurred up to the current index
                count += h.getOrDefault(currSum - k, 0);

                // add the current sum
                h.put(currSum, h.getOrDefault(currSum, 0) + 1);
            }

            return count;
        }
    }

    static class Solution3 {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int res = 0;
            int sum1 = 0;

            Map<Integer, Integer> numToFreq = new HashMap<>();
            // record the subarray sum
            // starts from the beginning of the array
            numToFreq.put(0, 1);

            for (int i = 0; i < nums.length; i++) {
                sum1 += nums[i];

                if (numToFreq.containsKey(sum1 - k)) {
                    res += numToFreq.get(sum1 - k);
                }

                numToFreq.put(sum1, numToFreq.getOrDefault(sum1, 0) + 1);
            }

            return res;
        }
    }
}
