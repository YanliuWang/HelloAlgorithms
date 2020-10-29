/**
 * @author yanliu
 * @create 2020-10-29-18:15
 */
public class RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int len = nums.length;
            int i = 0;

            while (i < len) {
                if (nums[i] == val) {
                    nums[i] = nums[len-1];
                    len--;

                } else {
                    i++;

                }
            }

            return len;

        }
    }
}
