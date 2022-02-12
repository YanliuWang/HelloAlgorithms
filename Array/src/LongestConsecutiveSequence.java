import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode128
 * @author yanliu
 * @create 2021-12-22-12:42 PM
 */
public class LongestConsecutiveSequence {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }

            int longest = 0;

            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i] - 1)) {
                    int currentNum = nums[i];
                    int currentStreak = 1;

                    while (set.contains(currentNum + 1)) {
                        currentStreak++;
                        currentNum++;
                    }

                    longest = Math.max(longest, currentStreak);
                }
            }

            return longest;
        }
    }
}
