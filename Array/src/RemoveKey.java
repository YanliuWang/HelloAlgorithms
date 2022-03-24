/**
 * Given an unsorted array of numbers and a target ‘key’,
 * remove all instances of ‘key’ in-place and return the new length of the array.
 * @author yanliu
 * @create 2022-03-18-10:58 PM
 */
public class RemoveKey {
    static class Solution1 {
        public int remove(int[] arr, int key) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int slow = 0, fast = 0;

            while (fast < arr.length) {
                if (arr[fast] != key) {
                    arr[slow] = arr[fast];
                    slow++;
                }

                fast++;
            }

            return slow;
        }
    }
}
