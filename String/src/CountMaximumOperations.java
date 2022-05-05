import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-11:59 AM
 */
public class CountMaximumOperations {
    static class Solution {
        public int countMaximumOperations(String s, String t) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            }

            for (char ch : t.toCharArray()) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }

            int count = Integer.MAX_VALUE;

            for (char ch : t.toCharArray()) {
                count = Math.min(count,
                        map1.getOrDefault(ch, 0) / map2.get(ch));
            }

            return count;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.countMaximumOperations("aaabc", "aa"));

        }
    }
}
