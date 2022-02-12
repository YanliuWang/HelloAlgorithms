import java.util.List;

/**
 * @author yanliu
 * @create 2021-03-14-15:43
 */
public class TowerOfHanoi {
    static class Solution {
        public void towerOfHanoi(List<Integer> A, List<Integer> B, List<Integer> C) {
            if (A == null || A.size() == 0) {
                return;
            }

            movePlates(A.size(), A, B, C);
        }

        private void movePlates(int num, List<Integer> original, List<Integer> auxiliary,
                                    List<Integer> target) {
            if (num == 1) {
                target.add(original.remove(original.size() - 1));
                return;
            }

            movePlates(num - 1, original, target, auxiliary);

            target.add(original.remove(original.size() - 1));

            movePlates(num - 1, auxiliary, original, target);
        }
    }

}
