/**
 * LeetCode26
 * @author yanliu
 * @create 2020-10-16-14:26
 */
public class RemoveDuplicatesFromSortedArray {
    class Solution1 {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // store next new number's index
            int nextNew = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i-1] == nums[i]) {
                    continue;

                } else {
                    nextNew++;

                }

                nums[nextNew] = nums[i];
            }

            return nextNew + 1;
        }
    }

    class Solution2 {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            int fast = 0;

            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;

                    nums[slow] = nums[fast];
                }

                fast++;
            }

            return slow + 1;
        }
    }
}
