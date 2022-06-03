import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode403
 * @author yanliu
 * @create 2022-05-19-11:42 AM
 */
public class FrogJump {
    class Solution1 {
        public boolean canCross(int[] stones) {
            if (stones == null || stones.length == 0) {
                return true;
            }

            Map<Integer, Set<Integer>> stoneToSteps = new HashMap<>();
            for (int i = 0; i < stones.length; i++) {
                stoneToSteps.put(stones[i], new HashSet<>());
            }

            // initial the starting state
            stoneToSteps.get(0).add(1);

            for (int i = 0; i < stones.length - 1; i++) {
                int stone = stones[i];

                for (int step : stoneToSteps.get(stone)) {
                    int reach = stone + step;

                    if (reach == stones[stones.length - 1]) {
                        return true;
                    }

                    if (stoneToSteps.containsKey(reach)) {
                        stoneToSteps.get(reach).add(step);

                        if (step - 1 > 0) {
                            stoneToSteps.get(reach).add(step - 1);
                        }

                        stoneToSteps.get(reach).add(step + 1);

                    }
                }
            }

            return false;

        }
    }
}
