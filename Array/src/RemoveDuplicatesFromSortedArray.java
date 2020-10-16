/**
 * @author yanliu
 * @create 2020-10-16-14:26
 */
public class RemoveDuplicatesFromSortedArray {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            // store next new number's index
            int nextNew = 0;


            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) {
                    continue;
                } else {
                    nextNew++;
                }

                nums[nextNew] = nums[i];

            }

            return nextNew + 1;
        }
    }
}
