/**
 * @author yanliu
 * @create 2021-10-13-10:31 AM
 */
public class MinimumSizeSubarraySum {
    class Solution1 {
        /**
         * using prefix sum to reduce time complexity of getting subarray sum
         * @param nums: an array of integers
         * @param s: An integer
         * @return: an integer representing the minimum size of subarray
         */
        public int minimumSize(int[] nums, int s) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int[] prefixSum = getPrefixSum(nums);
            int len = nums.length, minLen = Integer.MAX_VALUE;

            for (int start = 0; start < len; start++) {
                for (int end = start; end < len; end++) {
                    if (prefixSum[end + 1] - prefixSum[start] >= s) {
                        minLen = Math.min(minLen, end - start + 1);
                    }
                }
            }

            return minLen == Integer.MAX_VALUE ? -1 : minLen;
        }

        private int[] getPrefixSum(int[] nums) {
            int[] prefixSum = new int[nums.length + 1];

            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            return prefixSum;
        }
    }

    public class Solution2 {
        /**
         * using binary search
         * @param nums: an array of integers
         * @param s: An integer
         * @return: an integer representing the minimum size of subarray
         */
        public int minimumSize(int[] nums, int s) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int[] prefixSum = getPrefixSum(nums);
            int minLen = Integer.MAX_VALUE;

            for (int start = 0; start < nums.length; start++) {
                // get the right index of subarray
                int end = getEndOfSubarray(start, prefixSum, s);

                // check the prefixSum
                if (prefixSum[end + 1] - prefixSum[start] >= s) {
                    minLen = Math.min(minLen, end - start + 1);
                }
            }

            return minLen == Integer.MAX_VALUE ? -1 : minLen;
        }

        private int[] getPrefixSum(int[] nums) {
            int[] prefixSum = new int[nums.length + 1];

            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            return prefixSum;
        }

        private int getEndOfSubarray(int start, int[] prefixSum, int s) {
            // note : prefixSum.length = nums.length + 1
            int left = start, right = prefixSum.length - 2;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                // we need to check the prefixSum[mid] with prefixSum[start]
                if (prefixSum[mid + 1] - prefixSum[start] >= s) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            if (prefixSum[left + 1] - prefixSum[start] >= s) {
                return left;
            }

            return right;
        }
    }

    public class Solution3 {
        /**
         * two pointers
         * @param nums: an array of integers
         * @param s: An integer
         * @return: an integer representing the minimum size of subarray
         */
        public int minimumSize(int[] nums, int s) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int subArraySum = 0, n = nums.length;
            int minSize = Integer.MAX_VALUE;

            int j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && subArraySum < s) {
                    subArraySum += nums[j];
                    j++;
                }

                if (subArraySum >= s) {
                    minSize = Math.min(minSize, j - i);
                }

                subArraySum -= nums[i];
            }

            return minSize == Integer.MAX_VALUE ? -1 : minSize;
        }
    }
}
