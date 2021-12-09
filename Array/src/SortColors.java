/**
 * LeetCode 75
 * @author yanliu
 * @create 2021-11-16-11:47 AM
 */
public class SortColors {
    static class Solution {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            // 1. elements on the left side of p0 are all 0s
            // 2. elements on the right side of p2 are all 2s
            // 3. elements between p0 and p2 are all 1s
            int p0 = 0, p = 0, p2 = nums.length - 1;

            while (p <= p2) {
                if (p0 < p && nums[p] == 0) {
                    swap(nums, p0, p);
                    p0++;

                } else if (nums[p] == 2) {
                    swap(nums, p2, p);
                    p2--;

                } else {
                    p++;
                }
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
