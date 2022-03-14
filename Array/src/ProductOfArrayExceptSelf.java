/**
 * LeetCode238
 * @author yanliu
 * @create 2022-03-08-11:53 AM
 */
public class ProductOfArrayExceptSelf {
    static class Solution1 {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            int n = nums.length;
            int[] L = new int[n];
            int[] R = new int[n];

            L[0] = 1;
            for (int i = 1; i < n; i++) {
                L[i] = L[i - 1] * nums[i - 1];
            }

            R[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                R[i] = R[i + 1] * nums[i + 1];
            }

            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {
                ans[i] = L[i] * R[i];
            }

            return ans;
        }
    }

    static class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            int n = nums.length;
            int[] ans = new int[n];

            ans[0] = 1;

            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] * nums[i - 1];
            }

            int R = 1;

            for (int i = n - 1; i >= 0; i--) {
                ans[i] = ans[i] * R;
                R *= nums[i];
            }

            return ans;

        }
    }
}
