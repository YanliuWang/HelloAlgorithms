import java.util.HashMap;
import java.util.Map;

/**
 * LintCode 685
 * @author yanliu
 * @create 2021-07-29-22:04
 */
public class FirstUniqueNumberInDataStream {
    static class Solution {
        /**
         * @param nums: a continuous stream of numbers
         * @param number: a number
         * @return: returns the first unique number
         */
        public int firstUniqueNumber(int[] nums, int number) {
            // Write your code here
            if (nums == null || nums.length == 0) {
                return -1;
            }

            // denote whether the num in array nums is unique
            Map<Integer, Boolean> numToUnique = new HashMap<>(nums.length);

            for (int num : nums) {
                numToUnique.put(num, !numToUnique.containsKey(num));

                // arriving the terminate number
                // break
                if (num == number) {
                    break;
                }
            }

            // not contain terminate number
            if (!numToUnique.containsKey(number)) {
                return -1;
            }

            for (int num : nums) {
                // get the first unique number
                // return
                if (numToUnique.get(num)) {
                    return num;
                }
            }

            return -1;
        }
    }

}
