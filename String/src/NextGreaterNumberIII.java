/**
 * LeetCode556
 * @author yanliu
 * @create 2022-04-27-6:23 PM
 */
public class NextGreaterNumberIII {
    class Solution {
        public int nextGreaterElement(int n) {
            String str = String.valueOf(n);
            char[] nums = str.toCharArray();

            if (nums == null || nums.length == 0) {
                return -1;
            }

            int i = nums.length - 2;

            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            if (i == -1) {
                return -1;
            }

            int j = 0;
            if (i >= 0) {
                j = nums.length - 1;

                while (nums[j] <= nums[i]) {
                    j--;
                }
            }

            swap(nums, i, j);
            reverse(nums, i + 1);

            try {
                return Integer.parseInt(new String(nums));

            } catch (Exception e) {
                return -1;

            }
        }

        private void swap(char[] nums, int i, int j) {
            char tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void reverse(char[] nums, int start) {
            int end = nums.length - 1;

            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
}
