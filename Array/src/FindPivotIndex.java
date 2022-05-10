/**
 * LeetCode724
 * @author yanliu
 * @create 2022-05-08-10:24 AM
 */
public class FindPivotIndex {
    class Solution1 {
        public int pivotIndex(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            int[] prefixSum = new int[n + 1];

            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
            }

            for (int i = 0; i < nums.length; i++) {
                if (prefixSum[i] == prefixSum[n] - prefixSum[i + 1]) {
                    return i;
                }
            }

            return -1;
        }
    }

    class Solution2 {
        public int pivotIndex(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int prefixSum = 0;
            int leftSum = 0;

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
            }


            for (int i = 0; i < nums.length; i++) {
                if (leftSum == prefixSum - leftSum - nums[i]) {
                    return i;
                }

                leftSum += nums[i];
            }

            return -1;

        }
    }
}
