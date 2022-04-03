import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode13
 * @author yanliu
 * @create 2022-03-25-12:05 PM
 */
public class RomanToInteger {
    static class Solution1 {
        Map<Character, Integer> symbolToValue = new HashMap<>();

        public int romanToInt(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            symbolToValue.put('I', 1);
            symbolToValue.put('V', 5);
            symbolToValue.put('X', 10);
            symbolToValue.put('L', 50);
            symbolToValue.put('C', 100);
            symbolToValue.put('D', 500);
            symbolToValue.put('M', 1000);

            int res = 0;
            char[] arr = s.toCharArray();
            int i = 0;

            while (i < arr.length) {
                char curr = arr[i];
                int currValue = symbolToValue.get(curr);

                int nextValue = 0;

                if (i + 1 < arr.length) {
                    char next = arr[i + 1];
                    nextValue = symbolToValue.get(next);

                }

                if (currValue < nextValue) {
                    res += nextValue - currValue;
                    i += 2;

                } else {
                    res += currValue;
                    i += 1;
                }

            }

            return res;

        }
    }

    static class Solution2 {
        Map<String, Integer> symbolToValue = new HashMap<>();

        public int romanToInt(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            symbolToValue.put("I", 1);
            symbolToValue.put("V", 5);
            symbolToValue.put("IV", 4);
            symbolToValue.put("X", 10);
            symbolToValue.put("IX", 9);

            symbolToValue.put("L", 50);
            symbolToValue.put("XL", 40);
            symbolToValue.put("XC", 90);

            symbolToValue.put("C", 100);
            symbolToValue.put("D", 500);
            symbolToValue.put("CD", 400);

            symbolToValue.put("M", 1000);
            symbolToValue.put("CM", 900);

            int res = 0;
            int i = 0;

            while (i < s.length()) {
                if (i + 1 < s.length()) {
                    String doubleSymbol = s.substring(i, i + 2);

                    if (symbolToValue.containsKey(doubleSymbol)) {
                        res += symbolToValue.get(doubleSymbol);
                        i = i + 2;
                        continue;
                    }
                }

                String singleSymbol = s.substring(i, i + 1);

                res += symbolToValue.get(singleSymbol);

                i = i + 1;
            }

            return res;

        }
    }
}
