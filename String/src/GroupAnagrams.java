import java.util.*;

/**
 * LeetCode49
 * @author yanliu
 * @create 2021-12-29-9:59 PM
 */
public class GroupAnagrams {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> map = new HashMap<>();
            int[] count = new int[26];

            for (String str : strs) {
                Arrays.fill(count, 0);

                for (int i = 0; i < str.length(); i++) {
                    count[str.charAt(i) - 'a']++;
                }

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < count.length; i++) {
                    sb.append(count[i]);
                    sb.append("#");
                }

                if (!map.containsKey(sb.toString())) {
                    map.put(sb.toString(), new ArrayList<>());
                }

                map.get(sb.toString()).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }
}
