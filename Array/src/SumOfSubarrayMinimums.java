import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode907
 * @author yanliu
 * @create 2022-07-01-6:28 PM
 */
public class SumOfSubarrayMinimums {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            Deque<int[]> prevLess = new ArrayDeque<>();
            Deque<int[]> nextLess = new ArrayDeque<>();
            int[] prevLessDistance = new int[arr.length];
            int[] nextLessDistance = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                while (!prevLess.isEmpty() && prevLess.peek()[0] >= arr[i]) {
                    prevLess.pop();
                }

                prevLessDistance[i] = prevLess.isEmpty() ?
                        i + 1 : i - prevLess.peek()[1];
                prevLess.push(new int[]{arr[i], i});
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                while (!nextLess.isEmpty() && nextLess.peek()[0] > arr[i]) {
                    nextLess.pop();
                }

                nextLessDistance[i] = nextLess.isEmpty() ?
                        arr.length - i : nextLess.peek()[1] - i;
                nextLess.push(new int[]{arr[i], i});
            }

            long res = 0;
            long MOD = (long) 1e9 + 7;

            for (int i = 0; i < arr.length; i++) {
                res = (res + ((long) arr[i] * prevLessDistance[i]
                        * nextLessDistance[i])) % MOD;
            }

            return (int) res;
        }
    }
}
