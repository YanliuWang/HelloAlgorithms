import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given two arrays of integers a and b, which are both sorted in ascending order and contain unique elements (i.e. no duplicates).
 *
 * You can take several (possibly zero) numbers from the array b and add them to a at any positions in any order.
 *
 * You want the array a to be an arithmetic progression after this.
 *
 * Your task is to find the maximal length of the resulting arithmetic progression represented by array a that can be achieved.
 *
 * If it is impossible to obtain an array forming an arithmetic progression, return -1.
 *
 * Example:
 *
 * For a = [0, 4, 8, 16] and b = [0, 2, 6, 12, 14, 20], the output should be maxArithmeticLength(a, b) = 6.
 *
 * You can add b[3] = 12 and b[5] = 20 to a and obtain array [0, 4, 8, 12, 16, 20], which is an arithmetic progression of length 6 (the sequence increases by 4 from each element to the next).
 *
 * It is impossible to obtain a longer arithmetic progression, so the answer is 6.
 *
 * For a = [5, 7, 13, 14] and b = [9, 11, 15], the output should be maxArithmeticLength(a, b) = -1.
 *
 * It is impossible to obtain an arithmetic progression with these elements, so the answer is -1.
 *
 * An array a of unique integers sorted in ascending order.
 *
 * Guaranteed constraints:
 * 2 ≤ a.length ≤ 1000,
 * 0 ≤ a[i] ≤ 105.
 *
 * An array b of unique integers sorted in ascending order.
 *
 * Guaranteed constraints:
 * 2 ≤ b.length ≤ 1000,
 * 0 ≤ b[i] ≤ 105.
 *
 * @author yanliu
 * @create 2022-08-02-10:00 PM
 */
public class MaximumArithmeticSequence {
    static class Solution {
        public int maxLength(int[] a, int[] b) {
            if (a == null || b == null) {
                return 0;
            }


            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < a.length; i++) {
                minDiff = Math.min(minDiff, a[i] - a[i - 1]);
            }

            // get all factors of min difference
            List<Integer> factors = new ArrayList<>();
            for (int num = 1; num <= minDiff; num++) {
                if (minDiff % num != 0) {
                    continue;
                }

                factors.add(minDiff);
            }

            // put all numbers to sets
            Set<Integer> aSet = new HashSet<>();
            Set<Integer> bSet = new HashSet<>();

            for (int i = 0; i < a.length; i++) {
                aSet.add(a[i]);
            }
            for (int i = 0; i < b.length; i++) {
                bSet.add(b[i]);
            }


            int res = 0;
            // iterate the difference
            for (Integer diff : factors) {
                // get the left added count
                int start = a[0];
                int countToLeft = 0;
                while (bSet.contains(start - diff)) {
                    countToLeft++;
                    start -= diff;
                }

                // get the right added count
                start = a[0];
                int countToRight = 0;
                int countFromA = 0;
                while (aSet.contains(start) || bSet.contains(start)) {
                    if (aSet.contains(start)) {
                        countFromA++;
                    }

                    start += diff;
                    countToRight++;
                }

                if (countFromA == aSet.size()) {
                    res = Math.max(res, countToLeft + countToRight);
                }

            }

            return res == 0 ? -1 : res;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{0, 4, 8, 16};
        int[] b = new int[]{12, 14, 20};

        System.out.println(solution.maxLength(a, b));
    }
}
