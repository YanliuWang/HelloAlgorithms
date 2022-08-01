import java.util.*;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-9:35 AM
 */
public class KeypadClick {
    static class Solution1 {
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

    static class Solution2 {
        public int minimumKeypresses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            // using the array as hashmap
            Integer[] freq = new Integer[26];
            Arrays.fill(freq, 0);

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            // sort the arr in descending order
            Arrays.sort(freq, (x, y) -> y - x);

            int presses = 0;

            for (int i = 0; i < freq.length; i++) {
                presses += (freq[i] * (i / 9 + 1));
            }

            return presses;
        }

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String text = "abacadefghibj";

        System.out.println(solution.getKeypadClick(text));
    }

}
