import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode698
 * @author yanliu
 * @create 2022-07-07-7:27 PM
 */
public class PartitionToKEqualSumSubsets {
    class Solution {
        private Map<Integer, Boolean> memo;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k > nums.length) {
                return false;
            }

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            if (sum % k != 0) {
                return false;
            }

            int used = 0;
            int target = sum / k;
            memo = new HashMap<>();

            return backtrack(k, 0, nums, 0, target, used);
        }

        private boolean backtrack(int k, int bucket, int[] nums,
                                  int start, int target, int used) {
            if (k == 0) {
                return true;
            }

            if (bucket == target) {
                boolean res = backtrack(k - 1, 0, nums, 0, target, used);
                memo.put(used, res);

                return res;
            }

            if (memo.containsKey(used)) {
                return memo.get(used);
            }

            for (int i = start; i < nums.length; i++) {
                if (((used >> i) & 1) == 1) {
                    continue;
                }

                if (bucket + nums[i] > target) {
                    continue;
                }

                used |= 1 << i;
                bucket += nums[i];

                if (backtrack(k, bucket, nums, i + 1, target, used)) {
                    return true;
                }

                used ^= 1 << i;
                bucket -= nums[i];
            }

            return false;
        }
    }
}
