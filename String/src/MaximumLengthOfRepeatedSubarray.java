/**
 * LeetCode 718
 * @author yanliu
 * @create 2021-11-14-10:48 PM
 */
public class MaximumLengthOfRepeatedSubarray {
    static class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // dp[i][j] means the maximum length of the repeated subarray
            // end with nums1[i] and nums2[j]
            int[][] dp = new int[nums1.length][nums2.length];

            int res = 0;

            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;

                        res = Math.max(dp[i][j], res);
                    }
                }
            }

            return res;


        }
    }
}
