/**
 * LeetCode977
 * @author yanliu
 * @create 2021-12-04-9:43 AM
 */
public class SquaresOfASortedArray {
    static class Solution {
        public int[] sortedSquares(int[] nums) {
            int left = 0, right = nums.length - 1;
            int[] res = new int[nums.length];
            int index = nums.length - 1;

            while (left <= right) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    res[index] = nums[left] * nums[left];
                    left++;

                } else {
                    res[index] = nums[right] * nums[right];
                    right--;
                }

                index--;
            }

            return res;
        }
    }
}
