/**
 * https://www.algoexpert.io/questions/longest-peak
 * @author yanliu
 * @create 2022-06-19-5:57 PM
 */
public class LongestPeak {
    static class Solution {
        public static int longestPeak(int[] array) {
            // Write your code here.
            if (array == null || array.length < 3) {
                return 0;
            }

            int res = 0;

            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                    int left = i - 1, right = i + 1;

                    while (left > 0 && array[left - 1] < array[left]) {
                        left--;
                    }

                    while (right < array.length - 1 && array[right + 1] < array[right]) {
                        right++;
                    }

                    res = Math.max(right - left + 1, res);
                }
            }

            return res;
        }

        public static void main(String[] args) {
            int[] arr = new int[]{1, 2, 3, 4, 5, 1};
            System.out.println(longestPeak(arr));
        }
    }

}
