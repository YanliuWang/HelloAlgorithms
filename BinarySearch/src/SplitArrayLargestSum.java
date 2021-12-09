/**
 * LeetCode 410
 * @author yanliu
 * @create 2021-11-14-10:22 AM
 */
public class SplitArrayLargestSum {
    static class Solution {
        public int splitArray(int[] nums, int m) {
            // given a max value of the subarray
            // calculate the minimum number of subarray whose max subarray is less than max
            // get the minimum max of the given value of the subarray

            // get the lower and upper bound the given max value
            int lo = getMax(nums), hi = getSum(nums);

            // binary search
            while (lo + 1 < hi) {
                int mid = lo + (hi - lo) / 2;

                // the given max is mid right now
                // the minimum number of subarrays

                // split the nums at lease n parts
                int n = split(nums, mid);

                if (n > m) {
                    lo = mid + 1;

                } else if (n == m) {
                    hi = mid;

                } else if (n < m) {
                    hi = mid - 1;
                }
            }

            if (split(nums, lo) <= m) {
                return lo;
            }

            return hi;
        }

        // split the array to get subarrays
        // the max of the subarrays sum is less than the given max value
        // return the minimum number of subarrays
        private int split(int[] nums, int max) {
            // the number of subarrays
            int count = 1;

            int subarraySum = 0;

            for (int i = 0; i < nums.length; i++) {
                if (subarraySum + nums[i] > max) {
                    // we need to get next subarray
                    count++;
                    // renew the subarray
                    subarraySum = nums[i];

                } else {
                    subarraySum += nums[i];
                }
            }

            return count;
        }

        private int getSum(int[] nums) {
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            return sum;
        }

        private int getMax(int[] nums) {
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }

            return max;
        }
    }
}
