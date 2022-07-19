import java.util.List;

/**
 * We have an array of strings. Consider each
 * string as a zero-indexed array of characters.
 * All the characters will be in the range asciil[a-z]
 * which have decimal values in the range [97-122].
 * These decimal values are called ordinal values and will be referred to as ord[a]=97
 *
 * Perform the calculation on each string, sum
 * them up and print whether their sum is EVEN or ODD.
 *
 * @author yanliu
 * @create 2022-07-15-11:11 AM
 */
public class OddStrings {
    static class Solution {
        public String solve(int m, List<String> s) {
            boolean[] isEven = new boolean[s.size()];

            for (int i = 0; i < s.size(); i++) {
                boolean isEvenPresent = false;
                int value = 0;

                for (char ch : s.get(i).toCharArray()) {
                    value = (int) ch;

                    if (value % 2 == 0) {
                        isEvenPresent = true;
                    }
                }

                isEven[i] = isEvenPresent;
            }

            int oddCount = 0;

            for (int i = 0; i < isEven.length; i++) {
                if (!isEven[i]) {
                    oddCount++;
                }
            }

            return oddCount % 2 == 0 ? "EVEN" : "ODD";
        }
    }
}
