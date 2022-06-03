import java.util.HashMap;
import java.util.Map;

/**
 * https://www.educative.io/module/lesson/data-structures-in-java/m2JGw4Z3pLE
 * @author yanliu
 * @create 2022-06-02-5:10 PM
 */
public class FirstNonRepeatingInteger {
    class Solution {
        public int findFirstUnique(int[] arr) {
            if (arr == null || arr.length == 0) {
                return -1;
            }

            int result = 0;
            // write your code here
            Map<Integer, Integer> numToFreq = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                numToFreq.put(arr[i], numToFreq.getOrDefault(arr[i], 0) + 1);
            }

            for (int i = 0; i < arr.length; i++) {
                if (numToFreq.get(arr[i]) == 1) {
                    return arr[i];
                }
            }
            return -1;
        }
    }
}
