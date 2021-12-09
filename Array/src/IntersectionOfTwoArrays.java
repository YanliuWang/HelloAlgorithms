import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode350
 * @author yanliu
 * @create 2021-12-07-11:02 AM
 */
public class IntersectionOfTwoArrays {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }

            int[] intersection = new int[Math.min(nums1.length, nums2.length)];
            int index = 0;

            for (int i = 0; i < nums2.length; i++) {
                int count = map.getOrDefault(nums2[i], 0);

                if (count > 0) {
                    intersection[index++] = nums2[i];
                    count--;

                    if (count > 0) {
                        map.put(nums2[i], count);
                    } else {
                        map.remove(nums2[i]);
                    }
                }

            }

            return Arrays.copyOfRange(intersection, 0, index);
        }
    }
}
