/**
 * @author yanliu
 * @create 2020-10-31-19:16
 */
public class ReplaceElements {
    static class Solution {
        public int[] replaceElements(int[] arr) {
            if (arr == null || arr.length == 0) {
                return arr;
            }

            int maxNum = -1, tmp;

            for (int i = arr.length-1; i >= 0; i--) {
                tmp = arr[i];
                arr[i] = maxNum;
                maxNum = Math.max(maxNum, tmp);

            }

            return arr;
        }
    }
}
