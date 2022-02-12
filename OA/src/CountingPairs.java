/**
 * SnowFlake OA
 * @author yanliu
 * @create 2022-01-06-2:03 PM
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Given an integer k and a list of integers,
 * count the number of distinct valid pairs of integers(a,b) in the list for which a + k =b.
 */
public class CountingPairs {
    static class Solution1 {
        public int countPairs(List<Integer> numbers, int k) {
            Set<Integer> set = new HashSet<>(numbers);
            int res = 0;

            for (Integer num : set) {
                if (set.contains(num - k)) {
                    res++;
                }
            }

            return res;
        }
    }

    static class Solution2 {
        public int countPairs(List<Integer> numbers, int k) {
            Set<Integer> set = new HashSet<>();
            int res = 0;

            for (Integer num : numbers) {
                if (set.contains(num - k)) {
                    res++;

                } else {
                    set.add(num);

                }
            }

            return res;
        }
    }
}
