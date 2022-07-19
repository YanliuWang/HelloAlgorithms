/**
 * Given an array of integers, our goal is to find the length of the largest
 * subarray having the sum of its elements at most k where k > 0
 * @author yanliu
 * @create 2022-07-15-10:55 AM
 */
public class LongestSubarray {
    static class Solution1 {
        public int longestSubarray(int[] arr, int k) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int sum = 0;
            int count = 0;
            int res = 0;

            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= k) {
                    sum += arr[i];
                    count++;

                } else if (sum != 0) {
                    sum = sum - arr[i - count] + arr[i];

                }

                res = Math.max(res, count);

            }

            return res;
        }
    }

    static class Solution2 {
        public int longestSubarray(int[] arr, int k) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int left = 0, right = 0;
            int sum = 0;
            int len = 0;

            while (right < arr.length) {
                int in = arr[right];
                sum += in;
                right++;

                while (sum > k && right - left > 0) {
                    int out = arr[left];
                    sum -= out;
                    left++;

                }

                len = Math.max(len, right - left);

            }

            return len;
        }
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
//        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        int[] arr = {3, 1, 2, 3};
        int k = 4;
        System.out.println(s2.longestSubarray(arr, k));
    }
}
