/**
 * @author yanliu
 * @create 2020-10-26-10:45
 */
public class FindDuplicate {
    static class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }

            int tortoise = nums[0];
            int hare = nums[nums[0]];

            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            }

            tortoise = 0;

            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            return tortoise;
        }
    }
}
