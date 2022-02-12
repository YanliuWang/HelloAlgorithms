/**
 * LeetCode303
 * @author yanliu
 * @create 2022-02-08-12:07 PM
 */
public class RangeSumQueryImmutable {
    class NumArray {
        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = getPrefixSum(nums);
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }

        private int[] getPrefixSum(int[] nums) {
            int[] prefixSum = new int[nums.length + 1];

            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            return prefixSum;
        }
    }
}
