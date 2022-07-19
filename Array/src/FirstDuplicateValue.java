import java.util.HashSet;
import java.util.Set;

/**
 * https://www.algoexpert.io/questions/first-duplicate-value
 * @author yanliu
 * @create 2022-06-21-10:35 AM
 */
public class FirstDuplicateValue {
    class Solution1 {
        public int firstDuplicateValue(int[] array) {
            // Write your code here.
            if (array == null || array.length == 0) {
                return -1;
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < array.length; i++) {
                int curr = array[i];

                if (set.contains(curr)) {
                    return curr;
                }

                set.add(curr);
            }

            return -1;
        }
    }

    /**
     * 1. we can use value-to-index mapping as the hash function.
     * 2. The negative value represents repeat number.
     */
    class Solution2 {
        public int firstDuplicateValue(int[] array) {
            // Write your code here.
            if (array == null || array.length == 0) {
                return -1;
            }

            for (int value : array) {
                int idx = Math.abs(value) - 1;

                if (array[idx] < 0) {
                    return Math.abs(value);
                }

                array[idx] *= -1;
            }

            return -1;
        }
    }
}
