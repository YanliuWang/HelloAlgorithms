//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 770 👎 0

/**
 * @author yanliu
 * @create 2020-10-15-21:28
 */

public class MoveZeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("nums is null.");
            }

            // store next non-zero index
            int nonZeroIdx = 0;

            int i;

            for (i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[nonZeroIdx] = nums[i];
                    nonZeroIdx++;
                }
            }

            while (nonZeroIdx < nums.length) {
                nums[nonZeroIdx] = 0;
                nonZeroIdx++;
            }

        }
    }
}
