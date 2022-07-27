import java.util.HashMap;
import java.util.Map;

/**
 * Amazon OA
 * s, t, String problem
 * @author yanliu
 * @create 2022-07-25-12:02 AM
 */
public class LogAndTarget {
    static class Solution {
        public int countMaximumOperations(String s, String t) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            if (t == null || t.length() == 0) {
                return s.length();
            }

            Map<Character, Integer> logMap = new HashMap<>();
            Map<Character, Integer> targetMap = new HashMap<>();

            for (char ch : s.toCharArray()) {
                logMap.put(ch, logMap.getOrDefault(ch, 0) + 1);
            }

            for (char ch : t.toCharArray()) {
                targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
            }

            int res = Integer.MAX_VALUE;

            for (char key : targetMap.keySet()) {
                res = Math.min(res, logMap.getOrDefault(key, 0) / targetMap.get(key));
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abacbc";
        String t = "bca";

        System.out.println(solution.countMaximumOperations(s, t));
    }
}
