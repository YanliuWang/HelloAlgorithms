/**
 * LC979
 * @author yanliu
 * @create 2021-01-25-22:08
 */
public class DistributeCoins {
    static class Solution {
        private int moves = 0;

        public int distributeCoins(TreeNode root) {
            balance(root);

            return moves;
        }

        /**
         * return total moves of balancing the tree rooted in node
         * @param node
         * @return
         */
        private int balance(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int L = balance(node.left);
            int R = balance(node.right);

            moves += Math.abs(L) + Math.abs(R);

            // leave one coin
            return L + R + node.val - 1;
        }
    }
}
