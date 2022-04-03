import java.util.*;

/**
 * LeetCode2225
 * @author yanliu
 * @create 2022-04-02-10:19 PM
 */
public class FindPlayersWithZeroOrOneLosses {
    static class Solution1 {
        public List<List<Integer>> findWinners(int[][] matches) {
            Map<Integer, Integer> losses = new TreeMap<>();

            for (int[] m : matches) {
                losses.put(m[0], losses.getOrDefault(m[0], 0));
                losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
            }

            List<List<Integer>> res = Arrays.asList(new ArrayList<>(), new ArrayList<>());

            for (Integer player : losses.keySet()) {
                int loss = losses.get(player);

                if (loss <= 1) {
                    res.get(loss).add(player);
                }
            }

            return res;
        }
    }

    static class Solution2 {
        public List<List<Integer>> findWinners(int[][] matches) {
            Map<Integer, Integer> loserToFreq = new HashMap<>();
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                res.add(new ArrayList<>());
            }

            for (int[] match : matches) {
                loserToFreq.put(match[1], loserToFreq.getOrDefault(match[1], 0) + 1);
            }

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int[] match : matches) {
                if (!loserToFreq.containsKey(match[0])) {
                    set1.add(match[0]);
                }
            }

            for (Integer loser : loserToFreq.keySet()) {
                if (loserToFreq.get(loser) == 1) {
                    set2.add(loser);
                }
            }


            for (Integer s1 : set1) {
                res.get(0).add(s1);
            }

            for (Integer s2 : set2) {
                res.get(1).add(s2);
            }

            for (List<Integer> subRes : res) {
                Collections.sort(subRes);
            }
            return res;
        }
    }

}
