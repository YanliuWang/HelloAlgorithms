import java.util.List;

/**
 * @author yanliu
 * @create 2021-03-14-15:43
 */
public class Hanota {
    static class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            if (A == null || A.size() == 0) {
                return;
            }

            movePlate(A.size(), A, B, C);
        }

        private void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
            if (num == 1) {
                target.add(original.remove(original.size() - 1));
                return;
            }

            // put the n - 1 tablets to auxiliary using target
            movePlate(num - 1, original, target, auxiliary);

            // put the last one to target from original
            target.add(original.remove(original.size() - 1));

            // put the n - 1 tablets to
            movePlate(num - 1, auxiliary, original, target);

        }
    }
}
