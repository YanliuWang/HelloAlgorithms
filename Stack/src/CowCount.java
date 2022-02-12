/**
 * @author yanliu
 * @create 2022-01-12-9:55 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * problem: All the cows are facing right,
 *          and they can only see other cows
 *          in front of it and shorter than itself.
 *          It can be blocked by other taller cows.
 *          Get the sum of each cow can see how many other cows?
 */
public class CowCount {
    static class Solution {
        public int seeCows(int[] cows) {
            int n = cows.length;
            int totalSum = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                if (stack.isEmpty() || stack.peek() > cows[i]) {
                    stack.push(cows[i]);

                } else {
                    while (!stack.isEmpty() && stack.peek() <= cows[i]) {
                        stack.pop();
                        totalSum += stack.size();
                    }

                    stack.push(cows[i]);
                }
            }

            while (!stack.isEmpty()) {
                stack.pop();
                totalSum += stack.size();
            }

            return totalSum;
        }
    }
}
