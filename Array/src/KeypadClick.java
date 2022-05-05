import java.util.*;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-9:35 AM
 */
public class KeypadClick {
    static class Solution {
        public int findCount(String text) {
            if (text == null || text.length() == 0) {
                return 0;
            }

            Map<Character, Integer> charToCount = new HashMap<>();
            int len = text.length();

            for (int i = 0; i < len; i++) {
                char curr = text.charAt(i);
                charToCount.put(curr, charToCount.getOrDefault(curr, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new LinkedList<>(charToCount.entrySet());

            // sort the list based on the frequency
            Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                int digit = i / 9 + 1;
//                System.out.println("char is: " + list.get(i).getKey() + " freq is: " + list.get(i).getValue() + " digit is: " + digit);
                count += digit * list.get(i).getValue();
            }

            return count;

        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            String text = "abacadefghibj";

            System.out.println(solution.findCount(text));
        }
    }
}
