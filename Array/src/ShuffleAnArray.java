import java.util.Random;

/**
 * LeetCode 384
 * @author yanliu
 * @create 2021-11-21-9:52 PM
 */
public class ShuffleAnArray {
    static class Solution {
        private int[] backup;
        private int n;
        private Random random;

        public Solution(int[] nums) {
            backup = nums;
            n = nums.length;
            random = new Random();
        }

        public int[] reset() {
            return backup;
        }

        public int[] shuffle() {
            int[] ans = backup.clone();

            for (int i = 0; i < ans.length; i++) {
                swap(ans, i, i + random.nextInt(n - i));
            }

            return ans;
        }

        private void swap(int[] ans, int index1, int index2) {
            int tmp = ans[index1];
            ans[index1] = ans[index2];
            ans[index2] = tmp;
        }
    }
}
