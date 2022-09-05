/**
 * @author yanliu
 * @create 2022-09-05-2:47 PM
 */
public class FindTheLowestNumberInRange {
    static class Solution {
        public int getNum(int[] nums, int[] nRange) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int l = nRange[0];
            int r = nRange[1];
            int num = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > l && nums[i] < r && nums[i] < num) {
                    num = nums[i];
                }
            }

            return num == Integer.MAX_VALUE ? 0 : num;

        }
    }
}
