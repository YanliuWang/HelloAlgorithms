import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 438
 * @author yanliu
 * @create 2021-11-14-11:32 PM
 */
public class FindAllAnagramsInString {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();

            // constuct the need map
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for (int i = 0; i < p.length(); i++) {
                char ch = p.charAt(i);
                need.put(ch, need.getOrDefault(ch, 0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;

            while (right < s.length()) {
                char in = s.charAt(right);
                right++;

                if (need.containsKey(in)) {
                    window.put(in, window.getOrDefault(in, 0) + 1);

                    if (need.get(in).equals(window.get(in))) {
                        valid++;
                    }
                }

                while (right - left >= p.length()) {
                    char out = s.charAt(left);

                    if (valid == need.size()) {
                        res.add(left);
                    }

                    left++;

                    if (need.containsKey(out)) {
                        if (need.get(out).equals(window.get(out))) {
                            valid--;
                        }

                        window.put(out, window.get(out) - 1);
                    }
                }
            }

            return res;


        }
    }
}
