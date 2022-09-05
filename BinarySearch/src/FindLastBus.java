import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanliu
 * @create 2022-09-05-2:52 PM
 */
public class FindLastBus {
    static class Solution {
        public int solution(String[] schedule, String time) {
            if (schedule == null || schedule.length == 0) {
                return -1;
            }

            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            int target = h * 100 + m;

            List<Integer> nums = new ArrayList<>();

            for (String s : schedule) {
                String[] tt = s.split(":");
                int hh = Integer.parseInt(tt[0]);
                int mm = Integer.parseInt(tt[1]);

                nums.add(hh * 100 + mm);
            }

            int left = 0, right = nums.size() - 1;

            while (left + 1 < right) {
                int mid = left + (right - left) / 2;

                if (nums.get(mid) <= target) {
                    left = mid;

                } else {
                    right = mid - 1;

                }
            }

            int res = nums.get(right) <= target ? nums.get(right) : nums.get(left);

            if (res == target) {
                return -1;
            }

            return (res / 100 - h) * 60 + res % 100 - m;
        }
    }
}
