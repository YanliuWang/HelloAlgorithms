/**
 * LeetCode2293
 * @author yanliu
 * @create 2022-06-05-3:10 PM
 */
public class MinMaxGame {
    class Solution {
        public int minMaxGame(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int count = 0;
            int n = nums.length;

            while (n != 1) {
                n = n / 2;
                count++;
            }

            int len = nums.length;

            while (count > 0) {
                for (int i = 0; i < len / 2; i++) {
                    if (i % 2 == 0) {
                        nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);

                    } else {
                        nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);

                    }

                }

                count--;
                len = len / 2;
            }

            return nums[0];
        }
    }
}
