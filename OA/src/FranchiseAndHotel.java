import java.util.*;

/**
 * int[] f, int[] caf
 * f -> franchise，int from 1 to k，f代表第i个hotel是f旗下的旅店
 * caf是0或者1，代表第i个hotel的cafe是不是safe
 * 有两个agent要住店，要求住在同一个franchise的旅馆下，且不能是同一个旅馆，
 * 并且两个旅馆之前要至少有一个cafe是safe的。
 * e.g.如下，求有多少种住店的pair组合。
 * int[] f = {1,2,3,1,2,3}
 * int[] cafe = {0,0,1,0,0,1}
 * @author yanliu
 * @create 2022-04-04-5:13 PM
 */
public class FranchiseAndHotel {
    static class Solution {
        public static int solution(int[] f, int[] caf) {
            Map<Integer, Integer> zeroToCount = new HashMap<>();
            Map<Integer, Integer> oneToCount = new HashMap<>();

            for (int i = 0; i < caf.length; i++) {
                if (caf[i] == 0) {
                    zeroToCount.put(f[i],
                            zeroToCount.getOrDefault(f[i], 0) + 1);

                } else {
                    oneToCount.put(f[i],
                            oneToCount.getOrDefault(f[i], 0) + 1);

                }
            }

            int res = 0;

            Set<Integer> visited = new HashSet<>();

            for (int i = 0; i < f.length; i++) {
                if (visited.contains(f[i])) {
                    continue;
                }

                visited.add(f[i]);

                int unsafe = zeroToCount.getOrDefault(f[i], 0);
                int safe = oneToCount.getOrDefault(f[i], 0);

                if (unsafe + safe > 1 && safe > 0) {
                    res += unsafe * safe + safe * (safe - 1);
                }

            }

            return res;

        }

        public static void main(String[] args) {
            int[] f = new int[]{1, 2, 1};
            int[] cafe = new int[]{0, 1, 0};

            System.out.println(solution(f, cafe));
        }
    }

}
