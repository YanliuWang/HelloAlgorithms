import java.util.Arrays;

/**
 * LeetCode2294
 * @author yanliu
 * @create 2022-06-05-3:05 PM
 */
public class PartitionArrayMaximumDifferenceIsK {
    class Solution1 {
        public int partitionArray(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int res = 1;
            int min = nums[0];
            int i = 0;

            while (i < nums.length) {
                while (i < nums.length && nums[i] - min <= k) {
                    i++;
                }

                if (i >= nums.length) {
                    break;
                }

                min = nums[i];
                res++;
                i++;

            }

            return res;
        }
    }

    class Solution2 {
        public int partitionArray(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int res = 1;
            int prev = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - prev <= k) {
                    continue;
                }

                res++;
                prev = nums[i];
            }

            return res;

        }
    }
}
