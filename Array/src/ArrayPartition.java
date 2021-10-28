import java.util.Arrays;

/**
 * leetcode 561
 * @author yanliu
 * @create 2021-10-23-11:19 PM
 */
public class ArrayPartition {
    class Solution {
        public int arrayPairSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);
            int res = 0;

            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }

            return res;
        }

    }
}
