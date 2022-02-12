import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode739
 * @author yanliu
 * @create 2020-11-23-22:23
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }

        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = T.length - 1; i > -1; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);

            stack.push(i);

        }

        return res;
    }
}
