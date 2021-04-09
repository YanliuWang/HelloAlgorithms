import java.util.HashMap;
import java.util.Map;

/**Given an array of size n and an integer k,
 * return the of count of distinct numbers in all windows of size k.
 * @author yanliu
 * @create 2021-04-09-20:21
 */
public class CountDistinctWindow {
    static class Solution1 {
        static int[] countDistinct(int nums[], int k) {
            int[] res = new int[nums.length - k + 1];

            // store num to freq in each window with size k
            Map<Integer, Integer> numToFreq = new HashMap<>();

            int distinct = 0;

            // map nums to the first window
            for (int i = 0; i < k; i++) {
                if (numToFreq.containsKey(nums[i])) {
                    numToFreq.put(nums[i], numToFreq.get(nums[i]) + 1);

                } else {
                    numToFreq.put(nums[i], 1);
                    distinct++;

                }
            }

            res[0] = distinct;

            for (int i = k; i < nums.length; i++) {
                if (numToFreq.get(nums[i - k]) == 1) {
                    // Remove first element of previous window
                    // If there was only one occurrence
                    // reduce distinct count.
                    numToFreq.remove(nums[i - k]);
                    distinct--;

                } else {
                    // decrease the freq of the duplicated num
                    numToFreq.put(nums[i - k], numToFreq.get(nums[i - k]) - 1);
                }

                // add new element of current window
                if (numToFreq.containsKey(nums[i])) {
                    // if this element does not appear at the first time,
                    // increment the freq of the element
                    numToFreq.put(nums[i], numToFreq.get(nums[i]) + 1);

                } else {
                    // if the element appears the first time
                    // add distinct
                    numToFreq.put(nums[i], 1);
                    distinct++;

                }

                // count the distinct of current window
                res[i - k + 1] = distinct;
            }

            return res;

        }
    }
}
