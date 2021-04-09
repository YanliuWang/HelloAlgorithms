import java.util.HashSet;
import java.util.Set;

/**
 * LC219
 * @author yanliu
 * @create 2021-04-09-20:47
 */
public class ContainsNearbyDuplicate {
    static class Solution1 {
        public static boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            // use set to store elements in the array within distance k
            Set<Integer> numsWithinK = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (numsWithinK.contains(nums[i])) {
                    return true;
                }

                numsWithinK.add(nums[i]);

                if (numsWithinK.size() > k) {
                    numsWithinK.remove(nums[i - k]);
                }
            }

            return false;
        }
    }
}
