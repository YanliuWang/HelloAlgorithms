import java.util.Arrays;

/**
 * LeetCode 698
 * @author yanliu
 * @create 2021-11-30-9:56 AM
 */
public class PartitionKEqualSumSubsets {
    // do backtrack
    // try your best to minimize the selection space

    /**
     * from the number perspective to select buckets
     * O(k^n)
     */
    static class Solution1 {
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

            int[] bucket = new int[k];

            Arrays.sort(nums);
            reverse(nums);

            return dfs(nums, 0, bucket, sum / k);

        }

        private boolean dfs(int[] nums, int index, int[] bucket, int target) {
            if (index == nums.length) {
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i] != target) {
                        return false;
                    }
                }

                return true;
            }

            // put nums[index] -> bucket[i] ?
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] + nums[index] > target) {
                    continue;
                }

                bucket[i] += nums[index];

                if (dfs(nums, index + 1, bucket, target)) {
                    return true;
                }

                bucket[i] -= nums[index];
            }

            return false;
        }

        private void reverse(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;

                left++;
                right--;
            }
        }
    }

    /**
     * from the bucket perspective to select numbers
     * O(k*2^n)
     */
    static class Solution2 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k > nums.length) {
                return false;
            }

            int sum = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }

            if (sum % k != 0) {
                return false;
            }

            return dfs(k, 0, nums, 0, new boolean[n], sum / k);
        }

        private boolean dfs(int k, int bucket, int[] nums,
                            int start, boolean[] used, int target) {
            // no bucket is empty
            if (k == 0) {
                return true;
            }

            // current bucket is filled
            if (bucket == target) {
                return dfs(k - 1, 0, nums, 0, used, target);
            }

            // put numbers to current bucket
            for (int i = start; i < nums.length; i++) {
                // current number was put into other bucket
                if (used[i]) {
                    continue;
                }

                if (bucket + nums[i] > target) {
                    continue;
                }

                used[i] = true;
                bucket += nums[i];

                if (dfs(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }

                used[i] = false;
                bucket -= nums[i];

            }

            return false;
        }
    }
}
