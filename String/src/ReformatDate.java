import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1507
 * @author yanliu
 * @create 2021-11-21-10:18 AM
 */
public class ReformatDate {
    static class Solution {
        public String reformatDate(String date) {
            if (date == null || date.length() == 0) {
                return "";
            }

            Map<String, Integer> strToMonth = new HashMap<>();
            String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May",
                    "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            for (int i = 0; i < months.length; i++) {
                strToMonth.put(months[i], i + 1);
            }

            String[] array = date.split(" ");
            int year = Integer.parseInt(array[2]);
            int month = strToMonth.get(array[1]);
            int day = Integer.parseInt(array[0].substring(0, array[0].length() - 2));

            return String.format("%d-%02d-%02d", year, month, day);


        }
    }
}
