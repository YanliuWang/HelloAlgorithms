import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-04-11:42 PM
 */
public class MoveLocations {
    static class Solution {
        public int[] findDataLocations(int[] locations, int[] movedFrom, int[] movedTo) {
            Set<Integer> set = new HashSet<>();
            int n = locations.length;
            int m = movedFrom.length;

            for (int i = 0; i < n; i++) {
                set.add(locations[i]);
            }

            for (int i = 0; i < m; i++) {
                set.remove(movedFrom[i]);
                set.add(movedTo[i]);
            }

            int[] res = new int[set.size()];
            int idx = 0;

            for (int location : set) {
                res[idx++] = location;
            }

            Arrays.sort(res);

            return res;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] locations = {1, 7, 6, 8};
            int[] movedFrom = {1, 7, 2};
            int[] movedTo = {2, 9, 5};

            int[] res = solution.findDataLocations(locations, movedFrom, movedTo);

            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]);
            }
        }
    }
}
