import java.sql.Array;
import java.util.*;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-9:35 AM
 */
public class KeypadClick {
    static class Solution {
        public int getKeypadClick(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            Map<Character, Integer> charToFreq = new HashMap<>();

            for (char ch : s.toCharArray()) {
                charToFreq.put(ch, charToFreq.getOrDefault(ch, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(charToFreq.entrySet());

            // sort the entry list based on the frequency of each character
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            int clicks = 0;

            for (int i = 0; i < list.size(); i++) {
                int click = i / 9 + 1;
                System.out.println("char is: " + list.get(i).getKey() + " freq is: " + list.get(i).getValue() + " click is: " + click);
                clicks += click * list.get(i).getValue();
            }

            return clicks;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "abacadefghibj";

        System.out.println(solution.getKeypadClick(text));
    }

}
