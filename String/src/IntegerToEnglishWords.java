/**
 * LeetCode273
 * @author yanliu
 * @create 2022-01-02-9:23 PM
 */
public class IntegerToEnglishWords {
    static class Solution {
        private final String[] LESSTHAN20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        private final String[] TENS = {"", " Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        private final String SPACE = " ";

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }

            return helper(num);
        }

        private String helper(int num) {
            StringBuilder sb = new StringBuilder();

            if (num < 20) {
                sb.append(LESSTHAN20[num]);

            } else if (num < 100) {
                sb.append(TENS[num / 10]);

                if (num % 10 != 0) {
                    sb.append(SPACE).append(helper(num % 10));
                }

            } else if (num < 1000) {
                sb.append(helper(num / 100)).append(SPACE).append("Hundred");

                if (num % 100 != 0) {
                    sb.append(SPACE).append(helper(num % 100));
                }

            } else if (num < 1000000) {
                sb.append(helper(num / 1000)).append(SPACE).append("Thousand");

                if (num % 1000 != 0) {
                    sb.append(SPACE).append(helper(num % 1000));
                }

            } else if (num < 1000000000) {
                sb.append(helper(num / 1000000)).append(SPACE).append("Million");

                if (num % 1000000 != 0) {
                    sb.append(SPACE).append(helper(num % 1000000));
                }

            } else {
                sb.append(helper(num / 1000000000)).append(SPACE).append("Billion");

                if (num % 1000000000 != 0) {
                    sb.append(SPACE).append(helper(num % 1000000000));
                }
            }

            return sb.toString();
        }
    }
}
