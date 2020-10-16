/**
 * @author yanliu
 * @create 2020-10-16-15:02
 */
public class RotateArray {
    static class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;

            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, nums.length-1);
        }

        private void reverse(int[] nums, int start, int end) {
            if (start < 0 || end >= nums.length) {
                return;
            }

            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;

                start++;end--;
            }
        }


    }
}
