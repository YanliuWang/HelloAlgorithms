/**
 * Amazon OA1
 * @author yanliu
 * @create 2022-05-04-11:28 PM
 */
public class SearchWordAndResultWord {
    static class Solution1 {
        public int findMinimum(String searchWord, String resultWord) {
            if (resultWord == null || resultWord.length() == 0) {
                return 0;
            }

            if (searchWord == null || searchWord.length() == 0) {
                return resultWord.length();
            }

            int len1 = searchWord.length(), len2 = resultWord.length();

            int p1 = 0, p2 = 0;

            while (p1 < len1 && p2 < len2) {
                if (searchWord.charAt(p1) == resultWord.charAt(p2)) {
                    p1++;
                    p2++;

                } else {
                    p1++;

                }
            }

            return len2 - p2;
        }
    }

    static class Solution2 {
        public int findMinimum(String searchWord, String resultWord) {
            if (resultWord == null || resultWord.length() == 0) {
                return 0;
            }

            if (searchWord == null || searchWord.length() == 0) {
                return resultWord.length();
            }

            int p1 = 0, p2 = 0;

            while (p1 < searchWord.length() && p2 < resultWord.length()) {
                if (searchWord.charAt(p1) == resultWord.charAt(p2)) {
                    p1++;
                    p2++;

                } else {
                    p1++;

                }
            }

            return resultWord.length() - p2;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.findMinimum("armaze", "amazon"));
    }

}
