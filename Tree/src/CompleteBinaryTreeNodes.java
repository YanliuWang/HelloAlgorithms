/**
 * LC222
 * @author yanliu
 * @create 2020-12-22-11:22
 */
public class CompleteBinaryTreeNodes {
    static class Solution1 {
        /**
         * using recursion to count nodes
         * complete BT consists of a sub complete BT and a full BT
         * @param root
         * @return
         */
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            TreeNode l = root, r = root;
            int hl = 0, hr = 0;

            while (l != null) {
                hl++;
                l = l.left;
            }

            while (r != null) {
                hr++;
                r = r.right;
            }

            if (hl == hr) {
                return (1 << hr) - 1;

            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);

            }
        }
    }

    static class Solution2 {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // record the depth of the tree
            int depthPrevLast = countDepth(root) - 1;

            // record the second last level nodes position
            int start = 1, end = 1 << (depthPrevLast);

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (isExist(root, mid, depthPrevLast)) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }
            }

            int res = (1 << depthPrevLast) - 1 + start - 1;

            return res;
        }

        private int countDepth(TreeNode root) {
            int depth = 0;
            TreeNode curr = root;

            while (curr != null) {
                depth++;
                curr = curr.left;
            }

            return depth;
        }

        /**
         *
         * @param root : the root of currently searched tree
         * @param index : the index(1 based) of searched node in the last level
         * @param depth : the depth of the second last level
         * @return
         */
        private boolean isExist(TreeNode root, int index, int depth) {
            while (depth > 0) {
                int mid = (1 << depth) >> 1;

                if (index > mid) {
                    // 把迭代操作交给右子树
                    root = root.right;
                    // 把 index 也更新为对应的右子树中的 index
                    index -= mid;

                } else {
                    root = root.left;
                }

                depth--;
            }

            return root != null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        System.out.println(new Solution2().countNodes(root));
    }
}
