/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-3:13 PM
 */
public class MaximumAggregateTemperature  {
    static class Solution {
        public int findMaximum(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int n = arr.length;
            int[] left = new int[n];

            left[0] = arr[0];

            for (int i = 1; i < n; i++) {
                left[i] = arr[i] + left[i - 1];
            }

            int right = 0;
            int res = 0;

            for (int i = n - 1; i >= 0; i--) {
                right += arr[i];

                res = Math.max(res, Math.max(left[i], right));

            }

            return res;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] arr = {-1, 2, 3};

            System.out.println(solution.findMaximum(arr));
        }
    }
}
