/**
 * Expedia OA
 * @author yanliu
 * @create 2022-08-20-9:30 PM
 */
public class NumberOfAlerts {
    static class Solution {
        public int numberOfAlerts(int precedingMinutes, int alertThreshold, int[] minutes) {
            int res = 0;
            int sum = 0;

            int left = 0, right = 0;

            while (right < minutes.length) {
                int in = minutes[right];
                right++;

                sum += in;

                if (right - left == precedingMinutes) {
                    if (sum > alertThreshold * precedingMinutes) {
                        res++;
                    }

                    int out = minutes[left];
                    left++;
                    sum -= out;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int precedingMinutes = 3;
        int threshold = 10;
        int[] minutes = {0, 11, 10, 10, 7};

        Solution solution = new Solution();
        System.out.println(solution.numberOfAlerts(precedingMinutes, threshold, minutes));
    }
}
