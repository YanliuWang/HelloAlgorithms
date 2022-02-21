/**
 * LeetCode468
 * @author yanliu
 * @create 2022-02-19-11:45 AM
 */
public class ValidIPAddress {
    static class Solution {
        public String validIPAddress(String queryIP) {
            if (isIPv4(queryIP)) {
                return "IPv4";

            }

            if (isIPv6(queryIP)) {
                return "IPv6";
            }

            return "Neither";
        }

        private boolean isIPv4(String queryIP) {
            // limit is -1
            // no length limit for split
            // empty string will be discarded
            String[] arr = queryIP.split("\\.", -1);

            for (String s : arr) {
                try {
                    if (Integer.parseInt(s) > 255
                            || s.charAt(0) == '0' && s.length() > 1) {
                        return false;
                    }

                } catch (NumberFormatException e) {
                    return false;

                }
            }

            return arr.length == 4;

        }

        private boolean isIPv6(String queryIP) {
            // limit is -1
            // no length limit for split
            // empty string will be discarded
            String[] arr = queryIP.split("\\:", -1);

            for (String s : arr) {
                try {
                    if (Integer.parseInt(s, 16) > 65535 || s.length() > 4) {
                        return false;

                    }

                } catch(NumberFormatException e) {
                    return false;

                }

            }

            return arr.length == 8;


        }
    }
}
