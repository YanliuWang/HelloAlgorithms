/**
 * https://www.algoexpert.io/questions/monotonic-array
 * @author yanliu
 * @create 2022-06-14-10:01 PM
 */
public class MonotonicArray {
    class Solution1 {
        public boolean isMonotonic(int[] array) {
            // Write your code here.
            if (array == null || array.length < 2) {
                return true;
            }

            boolean isNonDecrease = false;

            int idx = 1;

            // we cannot get the monotonic based on the first pair
            // find the first different pair to get the monotonic
            while (idx < array.length) {
                if (array[idx] != array[idx - 1]) {
                    isNonDecrease = array[idx] > array[idx - 1];
                    break;
                }

                idx++;
            }

            while (idx < array.length) {
                int diff = array[idx] - array[idx - 1];

                if (diff == 0) {
                    idx++;
                    continue;
                }

                if (isNonDecrease && diff < 0) {
                    return false;
                }

                if (!isNonDecrease && diff > 0) {
                    return false;
                }

                idx++;

            }

            return true;
        }
    }

    class Solution2 {
        public boolean isMonotonic(int[] array) {
            // Write your code here.
            if (array == null || array.length < 2) {
                return true;
            }

            boolean isNonDecrease = true;
            boolean isNonIncrease = true;

            for (int i = 1; i < array.length; i++) {
                int diff = array[i] - array[i - 1];

                if (diff < 0) {
                    isNonDecrease = false;
                }

                if (diff > 0) {
                    isNonIncrease = false;
                }

            }
            return isNonDecrease || isNonIncrease;
        }
    }


}
