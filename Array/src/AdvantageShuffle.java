import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode870
 * @author yanliu
 * @create 2022-02-09-9:58 PM
 */
public class AdvantageShuffle {
    static class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            PriorityQueue<int[]> maxHeap =
                    new PriorityQueue<>(new Comparator<int[]>() {
                        public int compare(int[] o1, int[] o2) {
                            return o2[1] - o1[1];
                        }
                    }
                    );

            // sort the nums1 in ascending order
            Arrays.sort(nums1);

            int[] res = new int[nums1.length];

            // create max heap for the nums2
            for (int i = 0; i < nums2.length; i++) {
                maxHeap.offer(new int[]{i, nums2[i]});
            }

            int left = 0, right = nums1.length - 1;

            while (!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();

                int i = top[0], maxValue = top[1];

                if (nums1[right] > maxValue) {
                    res[i] = nums1[right];
                    right--;

                } else {
                    res[i] = nums1[left];
                    left++;
                }

            }

            return res;
        }
    }
}
