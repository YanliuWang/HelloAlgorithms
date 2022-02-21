import java.util.*;

/**
 * LeetCode350
 * @author yanliu
 * @create 2021-12-07-11:02 AM
 */
public class IntersectionOfTwoArrays {
    static class Solution1 {
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

    static class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[0];
            }

            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int one = 0, two = 0;
            List<Integer> list = new ArrayList<>();

            while (one < nums1.length && two < nums2.length) {
                while (one < nums1.length - 1 && nums1[one] == nums1[one + 1]) {
                    // one < nums1.length - 1 to make sure that 'one' is in the bound
                    one++;
                }
                while (two < nums2.length - 1 && nums2[two] == nums2[two + 1]) {
                    // two < nums2.length - 1 && nums2[two] == nums2[two + 1] to make sure that 'two' in bound
                    two++;
                }
                if (nums1[one] == nums2[two]) {
                    list.add(nums1[one]);
                    one++;
                    two++;
                }
                else if (nums1[one] > nums2[two]) {
                    two++;
                }
                else {
                    one++;
                }
            }

            int[] res = new int[list.size()];
            int i = 0;
            for (int each : list) {
                res[i] = each;
                i++;
            }
            return res;
        }
    }
}
