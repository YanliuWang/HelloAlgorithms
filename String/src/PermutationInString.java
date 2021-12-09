import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 567
 * @author yanliu
 * @create 2021-11-14-10:11 PM
 */
public class PermutationInString {
    static class Solution1 {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }

            int valid = 0;
            int left = 0, right = 0;

            while (right < s2.length()) {
                char in = s2.charAt(right);
                right++;

                // extend the window
                if (need.containsKey(in)) {
                    window.put(in, window.getOrDefault(in, 0) + 1);

                    // we have one match
                    if ((need.get(in)).equals(window.get(in))) {
                        valid++;
                    }
                }

                // shrink the window
                while (right - left >= s1.length()) {
                    if (valid == need.size()) {
                        return true;
                    }

                    char out = s2.charAt(left);
                    left++;

                    if (need.containsKey(out)) {
                        if ((need.get(out)).equals(window.get(out))) {
                            valid--;
                        }

                        window.put(out, window.get(out) - 1);
                    }
                }
            }

            return false;

        }
    }

    static class Solution2 {
        public boolean checkInclusion(String s1, String s2) {
            int[] count1 = new int[26];
            int[] count2 = new int[26];

            int len1 = s1.length();
            int len2 = s2.length();

            if (len1 > len2) {
                return false;
            }

            for (int i = 0; i < len1; i++) {
                count1[s1.charAt(i) - 'a']++;
                count2[s2.charAt(i) - 'a']++;
            }

            if (isEqual(count1, count2)) {
                return true;
            }

            for (int i = len1; i < len2; i++) {
                count2[s2.charAt(i) - 'a']++;
                count2[s2.charAt(i - len1) - 'a']--;

                if (isEqual(count1, count2)) {
                    return true;
                }
            }

            return false;
        }

        private boolean isEqual(int[] arr1, int[] arr2) {
            if (arr1 == null && arr2 == null) {
                return true;
            }

            if (arr1 == null || arr2 == null) {
                return false;
            }

            if (arr1.length != arr2.length) {
                return false;
            }

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
