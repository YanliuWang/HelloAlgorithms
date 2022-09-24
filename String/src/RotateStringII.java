/**
 * LintCode1790
 * @author yanliu
 * @create 2022-09-19-8:14 PM
 */
public class RotateStringII {
    public class Solution {
        /**
         * @param str: An array of char
         * @param left: a left offset
         * @param right: a right offset
         * @return: return a rotate string
         */
        public String rotateString2(String str, int left, int right) {
            // write your code here
            if (str == null || str.length() == 0) {
                return str;
            }

            StringBuilder sb = new StringBuilder();

            rotate(str, left - right, sb);

            return sb.length() == 0 ? str : sb.toString();
        }

        private void rotate(String str, int offset, StringBuilder sb) {
            if (offset == 0 || offset % str.length() == 0) {
                return;
            }

            offset %= str.length();

            if (offset > 0) {
                for (int i = offset; i < str.length(); i++) {
                    sb.append(str.charAt(i));
                }

                for (int i = 0; i < offset; i++) {
                    sb.append(str.charAt(i));
                }

            } else {
                for (int i = str.length() + offset; i < str.length(); i++) {
                    sb.append(str.charAt(i));
                }

                for (int i = 0; i < str.length() + offset; i++) {
                    sb.append(str.charAt(i));
                }

            }

        }
    }
}
