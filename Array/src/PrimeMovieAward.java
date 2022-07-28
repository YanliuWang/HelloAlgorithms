import java.util.Arrays;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-07-27-11:53 PM
 */
public class PrimeMovieAward {
    static class Solution {
        public int getMinimumGroups(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);
            int currMin = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - currMin > k) {
                    currMin = nums[i];
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 4, 6, 8, 9, 2};
        int k = 3;
        System.out.println(solution.getMinimumGroups(nums, k));

    }
}
