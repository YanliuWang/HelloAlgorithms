import java.util.HashSet;
import java.util.Set;

/**
 * @author yanliu
 * @create 2020-10-30-16:00
 */
public class CheckIfExist {
    static class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> seen = new HashSet<>();

            for (int num : arr) {
                // set contains 2 * num or half of num
                if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                    return true;
                }

                seen.add(num);
            }

            return false;
        }
    }
}
