import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 907
 * @author yanliu
 * @create 2021-10-29-7:27 PM
 */
public class SumSubarrayMinimums {
    static class Solution1 {
        private final int MOD = 1000_000_007;

        public int sumSubarrayMinimums(int[] arr) {
            if (arr == null || arr.length == 0) {
                return Integer.MAX_VALUE;
            }

            int N = arr.length;
            Deque<Integer> monoStack = new ArrayDeque<>();

            int[] prevLessElem = new int[N];
            for (int i = 0; i < N; i++) {
                while (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
                    // the left bound is less than or equal to the number
                    monoStack.pop();
                }

                prevLessElem[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
                monoStack.push(i);
            }

            monoStack = new ArrayDeque<>();
            int[] nextLessElem = new int[N];
            for (int i = N - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && arr[monoStack.peek()] >= arr[i]) {
                    // the right bound is strictly less than the number
                    monoStack.pop();
                }

                nextLessElem[i] = monoStack.isEmpty() ? N : monoStack.peek();
                monoStack.push(i);

            }

            long ans = 0;
            for (int i = 0; i < N; ++i) {
                // 注意：乘法可能越界，须要先转成 long 类型
                ans += (long) (i - prevLessElem[i]) * (nextLessElem[i] - i) % MOD * arr[i] % MOD;
                ans %= MOD;
            }
            return (int) ans;
        }
    }
}
