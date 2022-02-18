/**
 * LeetCode2161
 * @author yanliu
 * @create 2022-02-16-7:05 PM
 */
public class PartitionArrayAccordingGivenPivot {
    static class Solution {
        public int[] pivotArray(int[] nums, int pivot) {
            // lower numbers: [lo, same - 1]
            // same numbers : [same, hi - 1]
            // higher numbers : [hi, end]
            int lo = 0, same = 0, hi = nums.length;

            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];

                if (curr < pivot) {
                    same++;

                } else if (curr > pivot) {
                    hi--;

                }
            }

            int[] res = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];

                if (curr < pivot) {
                    res[lo++] = curr;

                } else if (curr == pivot) {
                    res[same++] = curr;

                } else {
                    res[hi++] = curr;
                }
            }

            return res;
        }
    }
}
